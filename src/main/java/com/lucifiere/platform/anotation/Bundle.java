package com.lucifiere.platform.anotation;

import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 包
 *
 * @author XD.Wang
 * @date 2018/4/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Bundle {

    String code();

    String desc() default StringUtils.EMPTY;

    String name() default StringUtils.EMPTY;

}
