package com.chain;

/**
 * 责任链节点
 * Created on 2017-04-17
 *
 * @author XD.Wang
 */
public abstract class BaseHandler {

    private enum FailedHandleStrategy {
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

    /**
     * 下游节点
     */
    protected BaseHandler nextHandler;

    protected FailedHandleStrategy failedHandleStrategy;

    /**
     * 判断是否有下游节点
     *
     * @return 是否有下游节点
     */
    protected boolean hasNext() {
        return nextHandler != null;
    }

    public BaseHandler(FailedHandleStrategy failedHandleStrategy) {
        this.failedHandleStrategy = failedHandleStrategy;
    }

    public BaseHandler() {
        this.failedHandleStrategy = FailedHandleStrategy.THROW_EXCEPTION;
    }

    /**
     * 设定本节点的下游节点
     *
     * @param nextHandler 下游节点
     * @return 下游节点
     */
    public BaseHandler nextIs(BaseHandler nextHandler) {
        this.nextHandler = nextHandler;
        return this.nextHandler;
    }

    /**
     * 执行节点逻辑
     *
     * @param req  节点逻辑必要上下文
     * @param resp 执行结果
     */
    public void execute(HandlerRequest req, HandlerResponse resp) {
        boolean isSuccess = false;
        try {
            isSuccess = doBizLogic(req, resp);
        } catch (BizFailedException e) {
            if (failedHandleStrategy == FailedHandleStrategy.THROW_EXCEPTION) {
                throw e;
            }
        }
        boolean toNextNode = (isSuccess || failedHandleStrategy == FailedHandleStrategy.IGNORE) && hasNext();
        if (toNextNode) {
            nextHandler.execute(req, resp);
        }
    }

    /**
     * 自定义业务逻辑
     *
     * @param req  节点逻辑必要上下文
     * @param resp 执行结果
     * @return 是否执行成功
     */
    abstract boolean doBizLogic(HandlerRequest req, HandlerResponse resp);

}
