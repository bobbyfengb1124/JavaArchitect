package singleton.registersingleton.enumsingleton;

import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {

    private static ConcurrentHashMap<String, Object> ioc = new ConcurrentHashMap<>();

    private ContainerSingleton() {
    }

    public static Object getBean(String className) {

        synchronized (ioc) {
            if (!ioc.containsKey(className)) {
                Object object = null;
                String string = "";
                string.getClass();

                return object;
            } else {
                return ioc.get(className);
            }
        }

    }

}
