package com.bofeng;

@RpcService(value = IHelloService.class, version = "2.0")
public class HelloServiceImpl2 implements IHelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("2.0 request in sayHello: " + name);
        return "2.0 Say Hello: " + name;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("2.0 request in saveUser: " + user);
        return "2.0 SUCCESS";
    }
}
