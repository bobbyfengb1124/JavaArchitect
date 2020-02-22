package my.spring.framework.framework.aop.intercept;

public interface MyMethodInterceptor {
    Object invoke(MyMethodInvocation mi) throws Throwable;
}