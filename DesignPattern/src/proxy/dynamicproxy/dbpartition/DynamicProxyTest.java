package proxy.dynamicproxy.dbpartition;


import proxy.staticproxy.datapartitioning.IOrderService;
import proxy.staticproxy.datapartitioning.Order;
import proxy.staticproxy.datapartitioning.OrderDao;
import proxy.staticproxy.datapartitioning.OrderService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DynamicProxyTest {

    public static void main(String[] args) {

        try {
            Order order = new Order();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

            Date date = sdf.parse("2018/02/01");

            order.setCreateTime(date.getTime());

            IOrderService proxy = (IOrderService) new DynamicProxy().getInstance(new OrderService(new OrderDao()));

            proxy.createOrder(order);
            System.out.println(proxy.getClass());

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
