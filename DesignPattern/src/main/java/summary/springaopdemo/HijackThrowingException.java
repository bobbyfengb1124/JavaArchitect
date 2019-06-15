package summary.springaopdemo;

import org.springframework.aop.ThrowsAdvice;

public class HijackThrowingException implements ThrowsAdvice {
    public void afterThrowing(IllegalArgumentException e) throws Throwable {
        System.out.println("HijackThrowException : Throw exception hijacked!");
    }
}
