package proxy.dynamicproxy.fbjdkproxy;

import java.lang.reflect.Method;

public interface FBInvocationHandler {
    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
