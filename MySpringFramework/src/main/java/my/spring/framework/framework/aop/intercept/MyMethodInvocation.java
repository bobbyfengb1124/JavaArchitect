package my.spring.framework.framework.aop.intercept;

import my.spring.framework.framework.aop.aspect.MyJointPoint;

import java.lang.reflect.Method;
import java.util.List;

public class MyMethodInvocation implements MyJointPoint {
    private Object proxy;
    private Method method;
    private Object target;
    private Class<?> targetClass;
    private Object[] arguments;
    private List<Object> interceptorsAndDynamicMethodMatchers;

    private int currentInterceptorIndex = -1;

    public MyMethodInvocation(Object proxy, Object target, Method method, Object[] args, Class<Object> targetClass, List<Object> interceptorsAndDynamicMethodMatchers) {
        this.proxy = proxy;
        this.target = target;
        this.method = method;
        this.targetClass = targetClass;
        this.arguments = args;
        this.interceptorsAndDynamicMethodMatchers = interceptorsAndDynamicMethodMatchers;
    }

    public Object proceed()throws Throwable {
        if (this.currentInterceptorIndex==this.interceptorsAndDynamicMethodMatchers.size()-1) {
            System.out.println("current index is the last one, going to call.");
            return this.method.invoke(this.target,this.arguments);
        }

        Object interceptorOrInterceptionAdvice =
                this.interceptorsAndDynamicMethodMatchers.get(++this.currentInterceptorIndex);
        if (interceptorOrInterceptionAdvice instanceof MyMethodInterceptor) {

            System.out.println("Going to call MyMethodInterceptor");
            MyMethodInterceptor mi = (MyMethodInterceptor) interceptorOrInterceptionAdvice;
            return mi.invoke(this);
        } else {
            return proceed();
        }

    }

    public Method getMethod() {
        return method;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public Object getThis() {
        return this.target;
    }
}
