package my.spring.framework.framework.aop;

import my.spring.framework.framework.aop.intercept.MyMethodInvocation;
import my.spring.framework.framework.aop.support.MyAdvisedSupport;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class MyJdkDynamicAopProxy implements MyAopProxy, InvocationHandler {
    MyAdvisedSupport config;

    public MyJdkDynamicAopProxy(MyAdvisedSupport config) {
        this.config = config;
    }

    @Override
    public Object getProxy() {
        return getProxy(this.config.getTargetClass().getClassLoader());
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return Proxy.newProxyInstance(classLoader,this.config.getTargetClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<Object> interceptorsAndDynamicMethodMatchers=
                config.getInterceptorsAndDynamicInterceptionAdvice(method, this.config.getTargetClass());

        MyMethodInvocation invocation
                = new MyMethodInvocation(proxy, this.config.getTarget(),
                method, args, this.config.getTargetClass(), interceptorsAndDynamicMethodMatchers);


        return invocation.proceed();
    }
}
