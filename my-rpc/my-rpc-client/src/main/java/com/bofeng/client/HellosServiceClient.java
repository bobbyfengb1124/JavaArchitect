package com.bofeng.client;

import com.bofeng.IHelloService;
import com.bofeng.User;

import java.lang.reflect.Proxy;

public class HellosServiceClient implements IHelloService {
    IHelloService proxy;

    public HellosServiceClient() {
        proxy = (IHelloService) Proxy.newProxyInstance(IHelloService.class.getClassLoader(),
                new Class[]{IHelloService.class},
                new RemoteInvocationHandler("localhost", 54321));
    }

    @Override
    public String sayHello(String name) {
        return proxy.sayHello(name);
    }

    @Override
    public String saveUser(User user) {
        return proxy.saveUser(user);
    }
}
