package my.spring.framework.framework.core;

public interface MyBeanFactory {
    Object getBean(String beanName) throws Exception;

    Object getBean(Class<?> beanClass) throws Exception;
}
