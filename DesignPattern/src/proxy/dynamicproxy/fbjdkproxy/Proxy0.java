package proxy.dynamicproxy.fbjdkproxy;


import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

public class Proxy0 implements proxy.staticproxy.findlove.Person {
    FBInvocationHandler h;

    public Proxy0(FBInvocationHandler h) {
        this.h = h;
    }

    public void findLove() {
        try {
            Method m = proxy.staticproxy.findlove.Person.class.getMethod("findLove");
            this.h.invoke(this, m, new Object[]{});
        } catch (Error _ex) {
        } catch (Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }
}
