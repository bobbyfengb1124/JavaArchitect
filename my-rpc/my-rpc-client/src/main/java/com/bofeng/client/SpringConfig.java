package com.bofeng.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.bofeng.client")
public class SpringConfig {
    @Bean(name = "hellosServiceClient")
    public HellosServiceClient HellosServiceClient() {
        return new HellosServiceClient();
    }
}
