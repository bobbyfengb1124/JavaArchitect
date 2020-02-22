package com.bofeng.client;

import com.bofeng.RpcRequest;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class RpcNetTransport {
    private String ip;
    private int port;

    public RpcNetTransport(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public Object send(RpcRequest request) {
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        Object result = null;
        try {
            Socket socket = new Socket(ip, port);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream.writeObject(request);
            System.out.println("written to output stream");
            objectOutputStream.flush();
            System.out.println("Flushed out the request.");

            result = objectInputStream.readObject();

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

        return result;
    }
}
