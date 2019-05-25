package proxy.dynamicproxy.dynamicmeipo;

import proxy.staticproxy.findlove.Person;

public class JDKMeipoTest {

    public static void main(String[] args) {

        try {
            Customer customer = new Customer();
            Person proxy = (Person) new JDKMeipo().getInstance(customer);
            proxy.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
