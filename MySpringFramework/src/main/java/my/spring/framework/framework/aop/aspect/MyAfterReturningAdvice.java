package my.spring.framework.framework.aop.aspect;

import my.spring.framework.framework.aop.intercept.MyMethodInterceptor;
import my.spring.framework.framework.aop.intercept.MyMethodInvocation;
import my.spring.framework.framework.aop.support.MyAdvice;

import java.lang.reflect.Method;

public class MyAfterReturningAdvice extends MyAbstractAspectJAdvice implements MyAdvice, MyMethodInterceptor {
    private MyJointPoint jointPoint;

    public MyAfterReturningAdvice(Method aspectMethod, Object aspectTarget) {
        super(aspectMethod, aspectTarget);
    }

    @Override
    public Object invoke(MyMethodInvocation mi) throws Throwable {
        Object retVal = mi.proceed();
        this.jointPoint = mi;
        this.afterReturning(retVal, mi.getMethod(), mi.getArguments(), mi.getThis());
        return retVal;
    }

    private void afterReturning(Object retVal, Method method, Object[] arguments, Object aThis) throws Throwable {
        invodeAdviceMethod(jointPoint, retVal, null);
    }
}
