package com.concurrent;

import com.collection.ListUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.*;

/**
 * 分页并发处理模型
 *
 * @param <REQ>  请求参数类型
 * @param <RESP> 返回对象类型
 * @author XD.Wang
 * @date 2018/10/31.
 */
public abstract class BasePagingConcurrentInvoker<REQ, RESP> {

    private static Logger LOGGER = LoggerFactory.getLogger(BasePagingConcurrentInvoker.class);

    /**
     * 默认请求超时时间
     */
    private static volatile long DEFAULT_EXECUTE_TIMEOUT = 50;

    /**
     * 线程池
     */
    private ExecutorService executorService;

    /**
     * 请求
     */
    private List<REQ> requests;

    /**
     * 每页请求size
     */
    private int pageSize;

    /**
     * 每页请求的超时时间
     */
    private long timeout;

    /**
     * 当线程池为null时，根据requests的大小和pageSize动态创建线程池
     * 线程池大小为（任务数 - 1）/ （页容量 + 1）
     *
     * @param executorService 线程池实现
     * @param requests        请求上下文队列
     * @param pageSize        分页参数
     * @param timeout         单次请求的超时时间
     */
    public BasePagingConcurrentInvoker(ExecutorService executorService, List<REQ> requests, int pageSize, long timeout) {
        Preconditions.checkArgument(CollectionUtils.isNotEmpty(requests) && pageSize > 1,
                "requests cannot empty and pageSize need lg 1");
        this.executorService = executorService;
        this.requests = requests;
        this.pageSize = pageSize;
        this.timeout = timeout;
        if (this.executorService == null) {
            this.executorService = getDefaultExecutor(requests, pageSize);
        }
        if (this.timeout <= 0) {
            this.timeout = DEFAULT_EXECUTE_TIMEOUT;
        }
    }

    /**
     * 默认线程池
     *
     * @param requests 请求上下文队列
     * @param pageSize 分页参数
     * @return 默认线程池
     */
    private ExecutorService getDefaultExecutor(List<REQ> requests, int pageSize) {
        int fixedNum = (requests.size() - 1) / pageSize + 1;
        return new ThreadPoolExecutor(fixedNum, fixedNum, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    /**
     * 是否并发处理
     *
     * @return 是否并发处理
     */
    public abstract boolean isConcurrent();

    /**
     * 执行自定义业务逻辑
     *
     * @param requests 请求上下文队列
     * @return 执行结果
     * @throws Exception Exception
     */
    protected abstract List<RESP> doBizLogic(List<REQ> requests) throws Exception;

    /**
     * 返回一个空结果
     *
     * @return 空结果
     */
    public abstract RESP emptyResponse();

    /**
     * 执行请求
     *
     * @return 执行结果
     */
    public List<RESP> execute() throws Exception {
        int requestTotalSize = requests.size();
        // 是否并发请求
        if (isConcurrent() && requestTotalSize > pageSize) {
            // 分页数
            int requestNum = (requestTotalSize - 1) / pageSize + 1;
            // 分页后每页请求数
            List<List<REQ>> requestLists = Lists.newArrayListWithCapacity(requestNum);
            requestLists.add(requests.subList(0, pageSize));
            for (int i = pageSize; i < requestTotalSize; i += pageSize) {
                int j = i + pageSize;
                if (j > requestTotalSize) {
                    j = requestTotalSize;
                }
                requestLists.add(requests.subList(i, j));
            }
            // 分页请求
            List<Future<List<RESP>>> futures = Lists.newArrayListWithCapacity(requestNum);
            for (final List<REQ> tmpRequests : requestLists) {
                futures.add(executorService.submit(() -> doBizLogic(tmpRequests)));
            }
            // 分页获取结果
            List<RESP> result = Lists.newArrayListWithCapacity(requestTotalSize);
            for (int i = 0; i < requestNum; ++i) {
                List<RESP> tmpResult = null;
                try {
                    tmpResult = futures.get(i).get(timeout, TimeUnit.MILLISECONDS);
                } catch (Throwable e) {
                    LOGGER.warn("任务【" + i + "】执行失败！", e);
                }
                if (tmpResult == null) {
                    tmpResult = ListUtils.generateHomogeneityList(requestLists.get(i).size(), emptyResponse());
                }
                result.addAll(tmpResult);
            }
            return result;
        } else {
            return doBizLogic(requests);
        }
    }
}
