package com.mhj.annotation;

import java.lang.annotation.*;

/**
 * @author mahuijian
 * @since 2020/6/9 11:28
 */
@Target(ElementType.TYPE)  //作用在类上
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited  //子类可以继承此注解
public @interface HandlePayType {
    /**
     * 策略类型
     *
     * @return int
     */
    int value();
}