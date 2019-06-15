package summary.iocdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("IOC-demo.xml");

        User user = (User) context.getBean("user");
        System.out.println("User name : " + user.getName() + " Age : " + user.getAge());
    }
}
