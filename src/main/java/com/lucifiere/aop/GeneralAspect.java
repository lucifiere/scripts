package com.lucifiere.aop;

import com.alibaba.fastjson.JSON;
import com.lucifiere.exceptions.BizException;
import com.lucifiere.exceptions.ErrorCode;
import com.lucifiere.result.BaseResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 基础方法拦截器，打印参数、耗时和摘要
 *
 * @author XD.Wang
 * @date 2018/4/23.
 */
@Aspect
@Component
public class GeneralAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralAspect.class);
    private static final Logger DIGEST_LOGGER = LoggerFactory.getLogger("digest-log");
    private static final Logger PARAM_LOGGER = LoggerFactory.getLogger("param-log");

    @Pointcut("execution(public * com.*.*(..))")
    public void apiInterceptor() {

    }

    @Around("apiInterceptor()")
    public Object intercept(ProceedingJoinPoint point) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Object target = point.getThis();
        Object[] arguments = point.getArgs();
        String className = target.getClass().getSimpleName();
        String methodName = methodSignature.getName();
        String appName = "XXX";
        // 是否成功
        String isSuccess = "F";
        long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = point.proceed();
            isSuccess = "T";
        } catch (BizException e) {
            result = createBaseExceptionResult(methodSignature, e);
        } catch (Exception e) {
            LOGGER.error("system error ", e);
            result = createExceptionResult(methodSignature);
        } finally {
            long diffTime = System.currentTimeMillis() - start;
            if (DIGEST_LOGGER.isInfoEnabled()) {
                DIGEST_LOGGER.info("({},{},{},{},{}ms )", appName, className, methodName, isSuccess, diffTime);
            }
            if (PARAM_LOGGER.isInfoEnabled()) {
                PARAM_LOGGER.info("{},{},{} >>>> args:{}", appName, className, methodName, JSON.toJSONString(arguments));
                PARAM_LOGGER.info("{},{},{} <<<< result:{}", appName, className, methodName, JSON.toJSONString(result));
            }
        }
        return result;
    }

    private BaseResult createBaseExceptionResult(MethodSignature methodSignature, BizException exception) throws IllegalAccessException, InstantiationException {
        BaseResult errorResult = (BaseResult) methodSignature.getDeclaringType().newInstance();
        errorResult.setErrorCode(exception.getCode());
        return errorResult;
    }

    private BaseResult createExceptionResult(MethodSignature methodSignature) throws IllegalAccessException, InstantiationException {
        BaseResult errorResult = (BaseResult) methodSignature.getReturnType().newInstance();
        errorResult.setErrorCode(ErrorCode.SYSTEM_ERROR);
        return errorResult;
    }

}
