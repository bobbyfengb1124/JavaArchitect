package singleton.registersingleton.enumsingleton;

import java.lang.reflect.Constructor;

public class ContainerSingletonTest {

    public static void main(String[] args) {
        try {
            Class clazz = ContainerSingleton.class;
            Constructor c = clazz.getDeclaredConstructor();
            c.setAccessible(true);
            Object enumSingleton = c.newInstance();
            Object enumSingleton2 = ContainerSingleton.getBean("ContainerSingleton");
            System.out.println(enumSingleton == enumSingleton2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
