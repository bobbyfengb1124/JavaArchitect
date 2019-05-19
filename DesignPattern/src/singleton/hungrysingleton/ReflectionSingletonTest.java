package singleton.hungrysingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionSingletonTest {

    public static void main(String[] args) {

        Class clazz = HungrySingleton.class;
        try {
            Constructor constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            System.out.println("1111");
            Object hungrySingleton1 = constructor.newInstance();
//			new HungrySingleton();
            System.out.println("use relection method to get object is:" + hungrySingleton1);
            Object hungrySingleton2 = HungrySingleton.getInstance();
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
