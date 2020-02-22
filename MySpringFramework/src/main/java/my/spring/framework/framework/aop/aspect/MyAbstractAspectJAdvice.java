package my.spring.framework.framework.aop.aspect;

import my.spring.framework.framework.aop.support.MyAdvice;

import java.lang.reflect.Method;

public class MyAbstractAspectJAdvice implements MyAdvice {

    private Method aspectMethod;
    private Object aspectTarget;

    public MyAbstractAspectJAdvice(Method aspectMethod, Object aspectTarget) {
        this.aspectMethod = aspectMethod;
        this.aspectTarget = aspectTarget;
    }

    protected Object invodeAdviceMethod(MyJointPoint jointPoint, Object returnValue,
                                        Throwable ex) throws Throwable {

        Class<?>[] paramTypes = this.aspectMethod.getParameterTypes();
        if (null == paramTypes || paramTypes.length == 0) {
            return this.aspectMethod.invoke(aspectTarget);
        } else {
            Object[] args = new Object[paramTypes.length];
            for (int i = 0; i < paramTypes.length; i++) {
                System.out.println("paramTypes[] " + i + " " + paramTypes[i].toString());
                if (paramTypes[i] == MyJointPoint.class) {
                    args[i] = jointPoint;
                } else if (paramTypes[i] == Throwable.class) {
                    args[i] = ex;
                } else if (paramTypes[i] == Object.class) {
                    args[i] = returnValue;
                }
            }
            return this.aspectMethod.invoke(aspectTarget, args);
        }

    }
}
