package com.lucifiere.pattern.chain;

/**
 * 责任链节点
 *
 * @author XD.Wang
 * @date 2018/4/23.
 */
public abstract class BaseHandler {

    /**
     * 下游节点
     */
    protected BaseHandler nextHandler;

    /**
     * 判断是否有下游节点
     *
     * @return 是否有下游节点
     */
    protected boolean hasNext() {
        return nextHandler != null;
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
     * 自定义业务逻辑
     *
     * @param req  节点逻辑必要上下文
     * @param resp 执行结果
     * @return 是否执行成功
     */
    protected abstract boolean doBizLogic(HandlerRequest req, HandlerResponse resp);

    /**
     * 业务逻辑入参校验
     *
     * @param req 业务逻辑入参
     */
    protected abstract void reqValidCheck(HandlerRequest req);

}
