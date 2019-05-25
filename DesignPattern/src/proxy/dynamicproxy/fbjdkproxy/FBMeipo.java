package proxy.dynamicproxy.fbjdkproxy;

import java.lang.reflect.Method;

public class FBMeipo implements FBInvocationHandler {
    private Object target;

    public Object getInstance(Object target) throws Exception {
        this.target = target;

        Class<?> clazz = target.getClass();

        return FBProxy.newProxyInstance(new FBClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        method.invoke(this.target, args);
        after();
        return null;
    }

    private void after() {
        System.out.println("If you agree, we will start.");
    }

    private void before() {
        System.out.println("I am agent: I am going to find a wife for you.");
        System.out.println("Let's start.");
    }
}
