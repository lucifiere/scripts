package com.lucifiere.exceptions;

/**
 * 参数校验异常
 *
 * @author XD.Wang
 * @date 2017/5/31.
 */
public class ArgumentCheckException extends BaseException {

    private static final long serialVersionUID = -7565868049636966438L;

    public ArgumentCheckException(String msg, ErrorCode code) {
        super(msg, code);
    }

    public ArgumentCheckException(ErrorCode code) {
        super(code.getDesc(), code);
    }

    public static ArgumentCheckException err() {
        return new ArgumentCheckException("业务执行失败", ErrorCode.BIZ_EXECUTE_FAILED);
    }

}
