package my.spring.framework.framework.aop;

public interface MyAopProxy {
    Object getProxy();
    Object getProxy(ClassLoader classLoader);
}
