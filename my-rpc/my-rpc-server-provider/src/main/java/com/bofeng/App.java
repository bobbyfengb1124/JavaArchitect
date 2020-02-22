package com.bofeng;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        //RpcProxyServer rpcProxyServer = new RpcProxyServer();
        //int port=54321;
        //rpcProxyServer.publish(new HelloServiceImpl(), port);

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ((AnnotationConfigApplicationContext) context).start();

    }
}
