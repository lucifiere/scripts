package com.lucifiere.pattern.chain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 责任链执行器
 *
 * @author XD.Wang
 * @date 2018/4/23.
 */
public class HandlerExecutor {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseHandler.class);

    public enum FailedHandleStrategy {
        /**
         * 终止并抛出异常
         */
        THROW_EXCEPTION,
        /**
         * 忽略并继续进行
         */
        IGNORE,
        /**
         * 终止并跳出
         */
        BREAK
    }

    private FailedHandleStrategy failedHandleStrategy;

    /**
     * 责任链根节点
     */
    private BaseHandler headHandler;

    /**
     * 当前执行的责任链节点
     */
    private BaseHandler curHandler;

    public HandlerExecutor(BaseHandler headHandler) {
        this.headHandler = headHandler;
        this.curHandler = headHandler;
        this.failedHandleStrategy = FailedHandleStrategy.THROW_EXCEPTION;
    }

    public HandlerExecutor(BaseHandler headHandler, FailedHandleStrategy failedHandleStrategy) {
        this.headHandler = headHandler;
        this.curHandler = headHandler;
        this.failedHandleStrategy = failedHandleStrategy;
    }

    /**
     * 执行责任链
     *
     * @param req  节点逻辑必要上下文
     * @param resp 执行结果
     */
    public void execute(BaseHandlerRequest req, BaseHandlerResponse resp) {
        boolean proceed = true;
        while (proceed) {
            proceed = execHandler(req, resp);
        }
    }

    /**
     * 执行节点逻辑 模板逻辑
     *
     * @param req  节点逻辑必要上下文
     * @param resp 执行结果
     * @return 是否继续执行
     */
    private boolean execHandler(BaseHandlerRequest req, BaseHandlerResponse resp) {
        boolean isSuccess = false;
        try {
            curHandler.reqValidCheck(req);
            isSuccess = curHandler.doBizLogic(req, resp);
        } catch (ChainExecFailedException e) {
            LOGGER.warn("业务校验未通过：" + e.getMessage());
            if (failedHandleStrategy == FailedHandleStrategy.THROW_EXCEPTION) {
                throw e;
            }
        }
        boolean proceed = (isSuccess || failedHandleStrategy == FailedHandleStrategy.IGNORE) && curHandler.hasNext();
        if (proceed) {
            curHandler = curHandler.nextHandler;
        }
        return proceed;
    }

}
