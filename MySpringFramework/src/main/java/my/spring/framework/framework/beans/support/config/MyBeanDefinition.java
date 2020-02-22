package my.spring.framework.framework.beans.support.config;

public class MyBeanDefinition {

    // 用于初始化的全类名
    private String beanClassName;

    // 是否是延迟加载
    private boolean lazyInit = false;

    // 这个累在工厂里面的名字，是全类名还是首字母小写，便于取用的
    private String factoryBeanName;

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    public String getFactoryBeanName() {
        return factoryBeanName;
    }

    public void setFactoryBeanName(String factoryBeanName) {
        this.factoryBeanName = factoryBeanName;
    }
}
