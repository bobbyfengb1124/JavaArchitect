package proxy.dynamicproxy.dynamicmeipo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKMeipo implements InvocationHandler {
    private Object target;

    public Object getInstance(Object target) throws Exception {

        this.target = target;
        Class<?> clazz = target.getClass();

        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(this.target, args);
        after();
        return null;
    }

    public void before() {
        System.out.println("I am the agent: I am going to find a wife for you. I got your requirements.");
        System.out.println("Let's start...");
    }

    public void after() {
        System.out.println("If you two agree, we can arrange for the marriage.");
    }
}
