package proxy.dynamicproxy.dbpartition;

import proxy.staticproxy.datapartitioning.DynamicDataSourceEntry;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DynamicProxy implements InvocationHandler {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;

        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object object = method.invoke(target, args);
        after();
        return object;
    }

    private void before(Object arg) {

        try {
            System.out.println("Proxy before method.");
            System.out.println("arg: " + arg);
            Long time = null;

            time = (Long) arg.getClass().getMethod("getCreateTime").invoke(arg);

            Integer dbRouter = Integer.valueOf(sdf.format(new Date(time)));
            System.out.println("JDK dynamic proxy auto assign to DB_" + dbRouter + "Datasource.");
            DynamicDataSourceEntry.set(dbRouter);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    private void after() {
        System.out.println("Proxy after method.");
    }
}
