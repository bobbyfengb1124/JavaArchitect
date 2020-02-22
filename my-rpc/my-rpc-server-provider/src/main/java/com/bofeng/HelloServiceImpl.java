package com.bofeng;

@RpcService(value = IHelloService.class, version = "1.0")
public class HelloServiceImpl implements IHelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("1.0 request in sayHello: " + name);
        return "1.0 Say Hello: " + name;
    }

    @Override
    public String saveUser(User user) {
        System.out.println("1.0 request in saveUser: " + user);
        return "1.0 SUCCESS";
    }
}
