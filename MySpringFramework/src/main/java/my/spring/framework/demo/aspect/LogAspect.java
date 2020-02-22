package my.spring.framework.demo.aspect;

import my.spring.framework.framework.aop.aspect.MyJointPoint;

import java.util.Arrays;

public class LogAspect {

    public void before(MyJointPoint jointPoint) {
        System.out.println("Invoker Before Method!!!" +
                "\nTargetObject:" + jointPoint.getThis() +
                "\nArgs: " + Arrays.toString(jointPoint.getArguments()));
    }

    public void after(MyJointPoint jointPoint) {
        System.out.println("Invoker After Method!!!" +
                "\nTargetObject:" + jointPoint.getThis() +
                "\nArgs: " + Arrays.toString(jointPoint.getArguments()));
    }

    public void afterThrowing(MyJointPoint jointPoint, Throwable ex) {
        System.out.println("Exception Occurred" +
                "\nTargetObject:" + jointPoint.getThis() +
                "\nArgs: " + Arrays.toString(jointPoint.getArguments())+
                "\nThrows: " + ex.getMessage());
    }
}
