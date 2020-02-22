package com.bofeng;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.bofeng")
public class SpringConfig {
    @Bean(name = "gpRpcServer")
    public GpRpcServer gpRpcServer() {
        return new GpRpcServer(54321);
    }
}
