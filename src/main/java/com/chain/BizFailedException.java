package com.chain;

/**
 * 责任链业务异常
 *
 * @author XD.Wang
 */
public class BizFailedException extends RuntimeException {

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

    public BizFailedException(String msg, String code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static BizFailedException err() {
        return new BizFailedException(DEFAULT_MSG, DEFAULT_CODE, null);
    }

    public static BizFailedException err(String msg, String code) {
        return new BizFailedException(msg, code, null);
    }

}
