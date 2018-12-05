package com.exceptions;

/**
 * 携带额外信息的异常
 */
public class InformativeBizException extends BaseException {

    private static final long serialVersionUID = -7565868049636236438L;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public InformativeBizException(String msg, ErrorCode code) {
        super(msg, code);
    }

    public InformativeBizException(ErrorCode code) {
        super(code.getDesc(), code);
    }

    public static InformativeBizException err() {
        return new InformativeBizException("业务执行失败", ErrorCode.BIZ_EXECUTE_FAILED);
    }

}
