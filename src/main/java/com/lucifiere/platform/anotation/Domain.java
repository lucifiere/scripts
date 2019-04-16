package com.lucifiere.platform.anotation;

import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.*;

/**
 * 域
 *
 * @author XD.Wang
 * @date 2018/4/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface Domain {

    String nameSpace() default StringUtils.EMPTY;

    String code();

    String desc() default StringUtils.EMPTY;

    String name() default StringUtils.EMPTY;

}
