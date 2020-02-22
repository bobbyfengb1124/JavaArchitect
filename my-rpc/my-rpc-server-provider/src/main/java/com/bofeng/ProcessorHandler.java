package com.bofeng;

import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ProcessorHandler implements Runnable {
    private Socket socket;
    private Map<String, Object> handlerMap = new HashMap<>();

    public ProcessorHandler(Socket socket, Map<String, Object> handlerMap) {
        this.socket = socket;
        this.handlerMap = handlerMap;
    }

    @Override
    public void run() {
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        System.out.println("Handling the request");

        try {
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            RpcRequest rpcRequest = (RpcRequest) objectInputStream.readObject();
            System.out.println("Received a request.");
            Object ret = invoke(rpcRequest);

            objectOutputStream.writeObject(ret);
            objectOutputStream.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object invoke(RpcRequest rpcRequest) {

        String serviceName;
        if (!StringUtils.isEmpty(rpcRequest.getVersion())) {
            serviceName = rpcRequest.getClassName() + "-" + rpcRequest.getVersion();
        } else {
            serviceName = rpcRequest.getClassName();
        }

        Object service = handlerMap.get(serviceName);
        if (service == null) {
            throw new RuntimeException("Service not found: " + serviceName);
        }
        Object ret = null;
        Object[] args = rpcRequest.getParameters();
        Class[] types = new Class[args.length];
        for (int i = 0; i < types.length; i++) {
            types[i] = args[i].getClass();
        }

        try {
            Class tClass = Class.forName(rpcRequest.getClassName());

            Method method = tClass.getMethod(rpcRequest.getMethodName(), types);
            ret = method.invoke(service, rpcRequest.getParameters());
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return ret;
    }
}
