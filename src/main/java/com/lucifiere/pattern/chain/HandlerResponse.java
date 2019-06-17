package com.lucifiere.pattern.chain;

/**
 * 节点执行结果
 *
 * @author XD.Wang
 * @date 2018/4/23.
 */
public class HandlerResponse {

    /**
     * 是否执行成功
     */
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
