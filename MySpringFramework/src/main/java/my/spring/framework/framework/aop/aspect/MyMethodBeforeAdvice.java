package my.spring.framework.framework.aop.aspect;

import my.spring.framework.framework.aop.intercept.MyMethodInterceptor;
import my.spring.framework.framework.aop.intercept.MyMethodInvocation;
import my.spring.framework.framework.aop.support.MyAdvice;

import java.lang.reflect.Method;

public class MyMethodBeforeAdvice extends MyAbstractAspectJAdvice implements MyAdvice, MyMethodInterceptor {
    private MyJointPoint jointPoint;

    public MyMethodBeforeAdvice(Method method, Object o) {
        super(method, o);
    }

    public void before(Method method, Object[] args, Object target) throws Throwable {
        invodeAdviceMethod(this.jointPoint, null, null);
    }

    @Override
    public Object invoke(MyMethodInvocation mi) throws Throwable {

        this.jointPoint = mi;
        this.before(mi.getMethod(), mi.getArguments(), mi.getThis());
        return mi.proceed();
    }
}
