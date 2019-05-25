package proxy.staticproxy.datapartitioning;

public class OrderDao {

    public int insert(Order order) {
        System.out.println("OrderDao created successfully.");
        return 1;
    }
}
