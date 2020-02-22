package my.spring.framework.framework.aop.aspect;

import java.lang.reflect.Method;

public interface MyJointPoint {
    Method getMethod();
    Object[] getArguments();
    Object getThis();
}
