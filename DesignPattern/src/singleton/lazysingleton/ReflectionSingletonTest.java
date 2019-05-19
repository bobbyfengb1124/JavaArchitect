package singleton.lazysingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionSingletonTest {

    public static void main(String[] args) {

//		System.out.println(Long.toHexString(327682));
        System.out.println(String.format("%06d", Long.valueOf(Long.toHexString(32768200))));

        Class clazz = LazyDoubleCheckSingleton.class;
        try {
            Constructor constructor = clazz.getDeclaredConstructor(null);
            constructor.setAccessible(true);
            System.out.println("1111");
            Object hungrySingleton1 = constructor.newInstance();
//			new HungrySingleton();
            System.out.println("use relection method to get object is:" + hungrySingleton1);
            Object hungrySingleton2 = LazyDoubleCheckSingleton.getInstance();
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


//		try {
//			LazyDoubleCheckSingleton instance1 = null;
//
//			LazyDoubleCheckSingleton.getInstanceDoubleCheck();
//			LazyDoubleCheckSingleton instance2 = LazyDoubleCheckSingleton.getInstanceDoubleCheck();
//
//			FileOutputStream fos = new FileOutputStream("LazyDoubleCheckSingleton.obj");
//			ObjectOutputStream oos = new ObjectOutputStream(fos);
//			oos.writeObject(instance2);
//			oos.flush();
//			oos.close();
//
//			FileInputStream fis = new FileInputStream("LazyDoubleCheckSingleton.obj");
//			ObjectInputStream ois = new ObjectInputStream(fis);
//			instance1 = (LazyDoubleCheckSingleton) ois.readObject();
//			ois.close();
//
//			System.out.println(instance1);
//			System.out.println(instance2);
//			System.out.println(instance1 == instance2);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}


    }

}
