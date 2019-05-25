package proxy.staticproxy.datapartitioning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StaticDBRouterTest {

    public static void main(String[] args) {
        try {
            OrderDao dao = new OrderDao();
            IOrderService service = new OrderService(dao);
            OrderServiceStaticProxy proxy = new OrderServiceStaticProxy(service);
            Order order = new Order();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2017/02/01");
            order.setCreateTime(date.getTime());

            proxy.createOrder(order);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
