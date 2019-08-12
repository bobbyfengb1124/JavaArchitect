package my.spring.framework.framework.beans;

public class MyBeanWrapper {
    private Object wrappedInstance;
    private Class<?> wrappedClass;

    public MyBeanWrapper() {
    }

    public MyBeanWrapper(Object instance) {
        this.wrappedInstance = instance;
    }

    public Object getWrappedInstance() {
        return wrappedInstance;
    }

    public void setWrappedInstance(Object wrappedInstance) {
        this.wrappedInstance = wrappedInstance;
    }

    public Class<?> getWrappedClass() {
        return wrappedClass;
    }

    public void setWrappedClass(Class<?> wrappedClass) {
        this.wrappedClass = wrappedClass;
    }
}
