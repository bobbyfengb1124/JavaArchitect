package singleton.lazysingleton;

public class LazyDoubleCheckSingleton {
    private static LazyDoubleCheckSingleton instance;

    private LazyDoubleCheckSingleton() {
    }

    public static LazyDoubleCheckSingleton getInstanceDoubleCheck() {
        if (instance == null) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (instance == null) {
                    return new LazyDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }

    public static synchronized LazyDoubleCheckSingleton getInstance() {
        if (instance == null) {
            return new LazyDoubleCheckSingleton();
        }
        return instance;
    }

}
