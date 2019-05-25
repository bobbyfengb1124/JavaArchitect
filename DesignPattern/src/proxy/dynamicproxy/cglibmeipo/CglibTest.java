package proxy.dynamicproxy.cglibmeipo;

import net.sf.cglib.core.DebuggingClassWriter;
import proxy.dynamicproxy.dynamicmeipo.Customer;

public class CglibTest {

    public static void main(String[] args) {
        try {
            System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/bofeng/Downloads");

            Customer customer = (Customer) new CglibMeipo().getInstance(Customer.class);
            customer.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
