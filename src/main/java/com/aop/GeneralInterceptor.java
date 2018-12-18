package com.aop;

import com.alibaba.fastjson.JSON;
import com.exceptions.BizException;
import com.exceptions.ErrorCode;
import com.result.BaseResult;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 基础方法拦截器，打印参数、耗时和摘要
 *
 * @author XD.Wang
 * @date 2018/4/23.
 */
public class GeneralInterceptor implements MethodInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralInterceptor.class);
    private static final Logger DIGEST_LOGGER = LoggerFactory.getLogger("digest-log");
    private static final Logger PARAM_LOGGER = LoggerFactory.getLogger("param-log");

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object target = invocation.getThis();
        Method method = invocation.getMethod();
        Object[] arguments = invocation.getArguments();
        String className = target.getClass().getSimpleName();
        String methodName = method.getName();
        String appName = "coupon";
        // 是否成功
        String isSuccess = "F";
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = invocation.proceed();
            isSuccess = "T";
        } catch (BizException e) {
            result = createBaseExceptionResult(method, e);
        } catch (Exception e) {
            LOGGER.error("system error", e);
            result = createExceptionResult(method);
        } finally {
            long diffTime = System.currentTimeMillis() - start;
            if (DIGEST_LOGGER.isInfoEnabled()) {
                DIGEST_LOGGER.info("({},{},{},{},{}ms)", appName, className, methodName, isSuccess, diffTime);
            }
            if (PARAM_LOGGER.isInfoEnabled()) {
                PARAM_LOGGER.info("{},{},{} >>>> args:{}", appName, className, methodName, JSON.toJSONString(arguments));
                PARAM_LOGGER.info("{},{},{} <<<< result:{}", appName, className, methodName, JSON.toJSONString(result));
            }
        }
        return result;
    }

    private BaseResult createBaseExceptionResult(Method method, BizException exception)
            throws IllegalAccessException, InstantiationException {
        BaseResult errorResult = (BaseResult) method.getReturnType().newInstance();
        errorResult.setErrorCode(exception.getCode());
        return errorResult;
    }

    private BaseResult createExceptionResult(Method method) throws IllegalAccessException, InstantiationException {
        BaseResult errorResult = (BaseResult) method.getReturnType().newInstance();
        errorResult.setErrorCode(ErrorCode.SYSTEM_ERROR);
        return errorResult;
    }

}
