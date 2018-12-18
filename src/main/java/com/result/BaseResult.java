package com.result;

import com.exceptions.ErrorCode;

/**
 * 调用结果
 *
 * @author XD.Wang
 * @date 2018/9/23.
 */
public class BaseResult implements Result {

    private boolean success;

    private ErrorCode errorCode;

    private String msg;

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BaseResult(boolean success, ErrorCode errorCode, String msg) {
        this.success = success;
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public BaseResult(boolean success, ErrorCode errorCode) {
        this.success = success;
        this.errorCode = errorCode;
    }

    public BaseResult(ErrorCode errorCode) {
        this.success = errorCode == null;
        this.errorCode = errorCode;
    }

    public BaseResult() {
        this.success = true;
        this.errorCode = null;
    }

}
