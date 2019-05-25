package proxy.staticproxy.datapartitioning;

public class OrderService implements IOrderService {
    OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public int createOrder(Order order) {
        System.out.println("Order Service calling orderDao to create order.");
        return orderDao.insert(order);
    }
}
