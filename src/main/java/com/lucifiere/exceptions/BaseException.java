package com.lucifiere.exceptions;

/**
 * 自定义异常基类
 *
 * @author XD.Wang
 * @date 2017/5/31.
 */
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = -7565868049636966438L;

    /**
     * 异常描述
     */
    private String msg;
    /**
     * 异常码
     */
    private ErrorCode code;

    public BaseException(String msg, ErrorCode code) {
        assert code != null;
        this.code = code;
        this.msg = msg;
    }

    public BaseException(ErrorCode code) {
        assert code != null;
        this.code = code;
        this.msg = code.getDesc();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }

}
