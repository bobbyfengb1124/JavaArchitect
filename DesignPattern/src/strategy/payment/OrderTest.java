package strategy.payment;

public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order("1", "20180311001000009", 324.45);

        System.out.println(order.pay(PayStrategy.ALI_PAY));
    }
}
