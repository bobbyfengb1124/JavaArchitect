package com.bofeng;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 类/接口
@Retention(RetentionPolicy.RUNTIME)
@Component //被spring扫描
public @interface RpcService {
    Class<?> value(); //拿到服务的接口

    String version() default "";
}
