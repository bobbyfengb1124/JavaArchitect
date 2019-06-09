package proxy.dynamicproxy.fbjdkproxy;

import proxy.dynamicproxy.dynamicmeipo.Customer;
import proxy.staticproxy.findlove.Person;

public class FBMeipoTest {
    public static void main(String[] args) {
        try {
            Person person = new Customer();
            FBMeipo fbMeipo = new FBMeipo();
            Person proxy = (Person) fbMeipo.getInstance(person);

            proxy.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
