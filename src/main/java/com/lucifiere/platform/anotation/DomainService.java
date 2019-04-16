package com.lucifiere.platform.anotation;

import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 域中的服务
 *
 * @author XD.Wang
 * @date 2018/4/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DomainService {

    String code();

    String desc() default StringUtils.EMPTY;

    String name() default StringUtils.EMPTY;

}
