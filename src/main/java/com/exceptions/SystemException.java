package com.exceptions;

/**
 * 系统异常
 */
public class SystemException extends BaseException {

    private static final long serialVersionUID = -2565868049636966438L;

    public SystemException(String msg, ErrorCode code) {
        super(msg, code);
    }

    public SystemException(ErrorCode code) {
        super(code.getDesc(), code);
    }

    public static SystemException err() {
        return new SystemException("系统异常", ErrorCode.SYSTEM_ERROR);
    }

}
