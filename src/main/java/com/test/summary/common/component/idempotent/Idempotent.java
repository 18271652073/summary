package com.test.summary.common.component.idempotent;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Administrator
 * 自定义注解(幂等)
 * @date 2020/6/16.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Idempotent {
    //注解自定义redis的key的一部分
    String key() default "Idempotent_";
    //过期时间
    long expirMillis() default 100L;
}
