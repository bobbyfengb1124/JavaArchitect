package decorator.v2;

public class DecoratorTest {
    public static void main(String[] args) {
        BatterCake cake = new BaseBattercake();

        cake = new EggDecorator(cake);
        cake = new EggDecorator(cake);
        cake = new SausageDecorator(cake);

        System.out.println(cake.getMsg() + "Total Price: " + cake.getPrice());

    }
}
