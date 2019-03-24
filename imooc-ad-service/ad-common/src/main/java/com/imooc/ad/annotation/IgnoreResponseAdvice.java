package com.imooc.ad.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//可以标示在类或者方法上
@Target({ElementType.METHOD,ElementType.TYPE})
//表示在运行时
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreResponseAdvice {
}
