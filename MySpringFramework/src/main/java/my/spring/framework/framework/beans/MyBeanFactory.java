package my.spring.framework.framework.beans;

public interface MyBeanFactory {
    Object getBean(String beanName) throws Exception;

    Object getBean(Class<?> beanClass) throws Exception;
}
