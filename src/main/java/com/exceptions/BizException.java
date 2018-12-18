package com.exceptions;

/**
 * 业务异常
 *
 * @author XD.Wang
 * @date 2017/5/31.
 */
public class BizException extends BaseException {

    private static final long serialVersionUID = -7565868049636966438L;

    public BizException(String msg, ErrorCode code) {
        super(msg, code);
    }

    public BizException(ErrorCode code) {
        super(code.getDesc(), code);
    }

    public static BizException err() {
        return new BizException("业务执行失败", ErrorCode.BIZ_EXECUTE_FAILED);
    }

}
