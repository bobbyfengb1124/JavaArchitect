package my.spring.framework.framework.beans.support;

import my.spring.framework.framework.beans.MyBeanDefinition;
import my.spring.framework.framework.context.support.MyAbstractApplicationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyDefaultListableBeanFactory extends MyAbstractApplicationContext {

    protected final Map<String, MyBeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

}
