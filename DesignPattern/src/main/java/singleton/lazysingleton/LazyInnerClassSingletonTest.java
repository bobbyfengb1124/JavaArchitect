package singleton.lazysingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LazyInnerClassSingletonTest {

    public static void main(String[] args) {
        Class clazz = LazyInnerClassSingleton.class;
        try {
            Constructor constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            System.out.println("1111");
            Object hungrySingleton1 = constructor.newInstance();
            System.out.println("use relection method to get object is:" + hungrySingleton1);
            Object hungrySingleton2 = LazyInnerClassSingleton.getInstance();
            System.out.println("use HungrySingleton method to get object is:" + hungrySingleton2);
            System.out.println(hungrySingleton1 == hungrySingleton2);
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
