package com.lucifiere.exceptions;

/**
 * 系统异常
 *
 * @author XD.Wang
 * @date 2017/5/31.
 */
public class SystemException extends BaseException {

    private static final long serialVersionUID = -2565868049636966438L;

    private Throwable cause;

    public SystemException(String msg, ErrorCode code, Throwable cause) {
        super(msg, code);
        this.cause = cause;
    }

    public SystemException(ErrorCode code, Throwable cause) {
        super(code.getDesc(), code);
        this.cause = cause;
    }

    public static SystemException err(Throwable cause) {
        return new SystemException("系统异常", ErrorCode.SYSTEM_ERROR, cause);
    }

}
