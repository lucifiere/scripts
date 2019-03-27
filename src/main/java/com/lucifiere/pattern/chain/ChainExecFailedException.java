package com.lucifiere.pattern.chain;

/**
 * 责任链执行异常
 *
 * @author XD.Wang
 * @date 2018/4/23.
 */
public class ChainExecFailedException extends RuntimeException {

    private static final String DEFAULT_MSG = "失败";

    private static final String DEFAULT_CODE = "FAILED";

    /**
     * 异常描述
     */
    private String msg;
    /**
     * 异常码
     */
    private String code;
    /**
     * 附带信息
     */
    private Object data;

    public ChainExecFailedException(String msg, String code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static ChainExecFailedException err() {
        return new ChainExecFailedException(DEFAULT_MSG, DEFAULT_CODE, null);
    }

    public static ChainExecFailedException err(String msg, String code) {
        return new ChainExecFailedException(msg, code, null);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
