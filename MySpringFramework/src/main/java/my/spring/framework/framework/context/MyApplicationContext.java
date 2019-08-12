package my.spring.framework.framework.context;

import my.spring.framework.framework.annotations.MyAutowired;
import my.spring.framework.framework.annotations.MyController;
import my.spring.framework.framework.annotations.MyService;
import my.spring.framework.framework.beans.MyBeanDefinition;
import my.spring.framework.framework.beans.MyBeanWrapper;
import my.spring.framework.framework.beans.support.MyBeanDefinitionReader;
import my.spring.framework.framework.beans.support.MyDefaultListableBeanFactory;
import my.spring.framework.framework.core.MyBeanFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class MyApplicationContext extends MyDefaultListableBeanFactory implements MyBeanFactory {

    private String[] configLocations;
    private MyBeanDefinitionReader reader;

    private Map<String, Object> singletonBeanCacheMap = new ConcurrentHashMap<>();

    private Map<String, MyBeanWrapper> beanWrapperMap = new ConcurrentHashMap<>();

    public MyApplicationContext() {
    }

    public MyApplicationContext(String... configLocations) {
        this.configLocations = configLocations;
        try {
            refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void refresh() throws Exception {
        //1、加载配置文件
        reader = new MyBeanDefinitionReader(this.configLocations);

        //2、扫描所有相关的类
        List<MyBeanDefinition> beanDefinitions = reader.loadBeanDefinitions();

        //3、初始化所有相关类的实例，并保存到IOC容器中
        doRegisterBeanDefinition(beanDefinitions);

        //4、依赖注入
        doAutowired();
    }

    private void doAutowired() {
        for (Map.Entry<String, MyBeanDefinition> beanDefinitionEntry : super.beanDefinitionMap.entrySet()) {
            String beanName = beanDefinitionEntry.getKey();
            if (!beanDefinitionEntry.getValue().isLazyInit()) {
                try {
                    getBean(beanName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doRegisterBeanDefinition(List<MyBeanDefinition> beanDefinitions) throws Exception {
        for (MyBeanDefinition beanDefinition : beanDefinitions) {
            if (super.beanDefinitionMap.containsKey(beanDefinition.getFactoryBeanName())) {
                throw new Exception("The " + beanDefinition.getFactoryBeanName() + " is exists!");
            }
            super.beanDefinitionMap.put(beanDefinition.getFactoryBeanName(), beanDefinition);
        }
    }

    @Override
    public Object getBean(String beanName) throws Exception {

        MyBeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);

        try {
            MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
            // instantiate bean
            Object instance = instantiateBean(beanDefinition);
            if (instance == null) {
                return null;
            }

            beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
            MyBeanWrapper beanWrapper = new MyBeanWrapper(instance);
            this.beanWrapperMap.put(beanName, beanWrapper);
            beanPostProcessor.postProcessAfterInitialization(instance, beanName);

            // populate bean
            populateBean(beanName, instance);

            return this.beanWrapperMap.get(beanName).getWrappedInstance();
        } catch (Exception e) {
            return null;
        }

    }

    private void populateBean(String beanName, Object instance) {
        Class clazz = instance.getClass();

        if (!(clazz.isAnnotationPresent(MyController.class) || clazz.isAnnotationPresent(MyService.class))) {
            return;
        }
        Field[] fields = clazz.getDeclaredFields();

        for (Field field :
                fields) {
            if (!field.isAnnotationPresent(MyAutowired.class)) {
                continue;
            }

            MyAutowired autowired = field.getAnnotation(MyAutowired.class);
            String autowiredBeanName = autowired.value().trim();
            if ("".equals(autowiredBeanName)) {
                autowiredBeanName = field.getType().getName();
            }
            field.setAccessible(true);

            try {
                field.set(instance, this.beanWrapperMap.get(autowiredBeanName).getWrappedInstance());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private Object instantiateBean(MyBeanDefinition beanDefinition) {
        Object instance = null;
        String className = beanDefinition.getBeanClassName();

        try {
            if (this.singletonBeanCacheMap.containsKey(className)) {
                instance = this.singletonBeanCacheMap.get(className);
            } else {
                Class<?> clazz = Class.forName(className);
                System.out.println("clazz: " + clazz);
                instance = clazz.newInstance();
                this.singletonBeanCacheMap.put(beanDefinition.getFactoryBeanName(), instance);
            }
            return instance;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Object getBean(Class<?> beanClass) throws Exception {
        return getBean(beanClass.getName());
    }

    public String[] getBeanDefinitionNames() {
        return this.beanDefinitionMap.keySet().toArray(new String[this.beanDefinitionMap.size()]);
    }

    public int getBeanDefinitionCount() {
        return this.beanDefinitionMap.size();
    }

    public Properties getConfig() {
        return this.reader.getConfig();
    }
}
