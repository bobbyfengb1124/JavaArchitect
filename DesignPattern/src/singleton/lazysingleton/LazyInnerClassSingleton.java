package singleton.lazysingleton;

public class LazyInnerClassSingleton {

    public static LazyInnerClassSingleton getInstance() {
        return SingletonHolder.LAZY;
    }

    private static class SingletonHolder {
        public static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
