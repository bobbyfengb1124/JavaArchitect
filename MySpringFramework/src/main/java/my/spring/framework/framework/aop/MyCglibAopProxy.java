package my.spring.framework.framework.aop;

import my.spring.framework.framework.aop.support.MyAdvisedSupport;

public class MyCglibAopProxy implements MyAopProxy{
    private MyAdvisedSupport config;

    public MyCglibAopProxy(MyAdvisedSupport config) {
        this.config = config;
    }

    public Object getProxy() {
        return null;
    }

    public Object getProxy(ClassLoader classLoader) {
        return null;
    }
}
