package decorator.v2;

public class BaseBattercake extends BatterCake {
    @Override
    protected String getMsg() {
        return "Batter Cake";
    }

    @Override
    protected int getPrice() {
        return 5;
    }
}
