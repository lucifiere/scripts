package com.lucifiere.result;

import com.lucifiere.exceptions.ErrorCode;

/**
 * 调用结果接口
 *
 * @author XD.Wang
 * @date 2018/9/23.
 */
public interface Result {

    boolean isSuccess();

    ErrorCode getErrorCode();

}
