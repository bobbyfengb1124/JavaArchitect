package proxy.staticproxy.datapartitioning;

public class DynamicDataSourceEntry {

    public final static String DEFAULT_SOURCE = null;

    private final static ThreadLocal<String> local = new ThreadLocal<>();

    private DynamicDataSourceEntry() {
    }

    public static void clear() {
        local.remove();
    }

    public static String get() {
        return local.get();
    }

    public static void restore() {
        local.set(DEFAULT_SOURCE);
    }

    public static void set(int year) {
        local.set("DB_" + year);
    }
}
