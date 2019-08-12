package my.spring.framework;

import my.spring.framework.framework.context.MyApplicationContext;

public class Test {
    public static void main(String[] args) {
        MyApplicationContext context = new MyApplicationContext("application.properties");

        Object bean = null;
        try {
            bean = context.getBean("demoAction");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(bean);

    }
}
