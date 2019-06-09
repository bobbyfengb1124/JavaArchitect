package decorator.v2;

public class EggDecorator extends BattercakeDecorator {
    public EggDecorator(BatterCake batterCake) {
        super(batterCake);
    }

    @Override
    protected void doSomething() {

    }

    @Override
    protected String getMsg() {
        return super.getMsg() + "1 egg.";
    }

    @Override
    protected int getPrice() {
        return super.getPrice() + 1;
    }
}
