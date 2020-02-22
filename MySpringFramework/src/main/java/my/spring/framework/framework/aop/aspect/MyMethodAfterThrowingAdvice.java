package my.spring.framework.framework.aop.aspect;

import my.spring.framework.framework.aop.intercept.MyMethodInterceptor;
import my.spring.framework.framework.aop.intercept.MyMethodInvocation;
import my.spring.framework.framework.aop.support.MyAdvice;

import java.lang.reflect.Method;

public class MyMethodAfterThrowingAdvice extends MyAbstractAspectJAdvice implements MyAdvice, MyMethodInterceptor {
    private String throwingName;
    private MyMethodInvocation mi;

    public MyMethodAfterThrowingAdvice(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    public void setThrowingName(String throwingName) {
        this.throwingName = throwingName;
    }

    @Override
    public Object invoke(MyMethodInvocation mi) throws Throwable {
        try {
            return mi.proceed();
        } catch (Throwable ex) {
            invodeAdviceMethod(mi, null, ex.getCause());
            throw ex;
        }
    }
}
