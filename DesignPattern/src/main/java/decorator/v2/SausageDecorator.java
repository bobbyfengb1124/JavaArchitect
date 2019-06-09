package decorator.v2;

public class SausageDecorator extends BattercakeDecorator {
    public SausageDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "1 Sausage";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 2;
    }
}
