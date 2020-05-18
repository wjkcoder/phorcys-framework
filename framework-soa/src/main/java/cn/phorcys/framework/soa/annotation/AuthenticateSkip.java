package cn.phorcys.framework.soa.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Wonder
 * @Date: Created on 2020/5/11 12:31 上午
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface AuthenticateSkip {
    /**
     * 是否需要校验访问权限 默认不校验
     *
     * @return
     */
    boolean permission() default true;
}
