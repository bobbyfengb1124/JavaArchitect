package com.bofeng.client;

import com.bofeng.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RemoteInvocationHandler implements InvocationHandler {
    private String ip;
    private int port;

    public RemoteInvocationHandler(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Come in");
        RpcRequest request = new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameters(args);
        request.setVersion("1.0");

        RpcNetTransport netTransport = new RpcNetTransport(ip, port);
        System.out.println("Going to send out the request");
        Object result = netTransport.send(request);

        return result;
    }
}
