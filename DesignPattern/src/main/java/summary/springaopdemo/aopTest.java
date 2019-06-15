package summary.springaopdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class aopTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"Spring-Customer.xml"});

        CustomerService customerService = (CustomerService) applicationContext.getBean("customerServiceProxy");

        System.out.println("******************************");
        customerService.printName();
        System.out.println("******************************");
        customerService.printURL();
        System.out.println("******************************");
        try {
            customerService.printThrowException();
        } catch (Exception e) {

        }
    }
}
