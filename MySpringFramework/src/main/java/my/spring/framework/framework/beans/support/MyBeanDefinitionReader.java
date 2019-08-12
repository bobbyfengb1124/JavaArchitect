package my.spring.framework.framework.beans.support;

import my.spring.framework.framework.beans.MyBeanDefinition;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MyBeanDefinitionReader {

    private final String SCAN_PACKAGE = "scanPackage";
    private List<String> registryBeanClasses = new ArrayList<>();
    private Properties config = new Properties();

    public MyBeanDefinitionReader() {
    }

    public MyBeanDefinitionReader(String... configLocations) {

        System.out.println("configLocations: " + configLocations[0]);
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(configLocations[0].replace("classpath:", ""));
        System.out.println("InputStream is: " + is);
        try {
            config.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("config property: " + config.getProperty(SCAN_PACKAGE));
        doScanner(config.getProperty(SCAN_PACKAGE));
    }

    private void doScanner(String property) {
        URL url = this.getClass().getResource("/" + property.replaceAll("\\.", "/"));
        System.out.println("URL: " + url);

        File classPath = new File(url.getFile());
        for (File file :
                classPath.listFiles()) {
            if (file.isDirectory()) {
                doScanner(property + "." + file.getName());
            } else {
                if (!file.getName().endsWith(".class")) {
                    continue;
                }
                String className = (property + "." + file.getName().replace(".class", ""));
                registryBeanClasses.add(className);
            }
        }
    }

    public List<MyBeanDefinition> loadBeanDefinitions() {
        List<MyBeanDefinition> result = new ArrayList<>();
        for (String className :
                registryBeanClasses) {
            try {
                System.out.println("className: " + className);
                Class<?> beanClass = Class.forName(className);
                if (beanClass.isInterface()) {
                    continue;
                }
                if (Modifier.isAbstract(beanClass.getModifiers())) {
                    System.out.println("This class is abstract class: " + beanClass.getName() + ". Will ignore when instantiation.");
                    continue;
                }

                System.out.println("Simple Name: " + toLowerFirstCase(beanClass.getSimpleName()));
                System.out.println("Class Name: " + beanClass.getName());
                result.add(doCreateBeanDefinition(toLowerFirstCase(beanClass.getSimpleName()), beanClass.getName()));
                Class<?>[] interfaces = beanClass.getInterfaces();
                for (Class<?> i :
                        interfaces) {
                    result.add(doCreateBeanDefinition(i.getName(), beanClass.getName()));
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private MyBeanDefinition doCreateBeanDefinition(String factoryClassName, String beanClassName) {
        MyBeanDefinition beanDefinition = new MyBeanDefinition();
        beanDefinition.setBeanClassName(beanClassName);
        beanDefinition.setFactoryBeanName(factoryClassName);

        return beanDefinition;
    }

    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();

        chars[0] += 32;
        return String.valueOf(chars);
    }

    public Properties getConfig() {
        return this.config;
    }
}
