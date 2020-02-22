package com.bofeng.client;

import com.bofeng.IHelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        //IHelloService proxy = new HellosServiceClient();
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        IHelloService proxy = context.getBean(HellosServiceClient.class);
        System.out.println(proxy.sayHello("Bob"));
    }
}
