package com.lucifiere.platform.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 别名
 *
 * @author XD.Wang
 * @date 2018/4/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Alias {

    String name();

    int prioirty() default 1;

}
