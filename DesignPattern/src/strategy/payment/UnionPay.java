package strategy.payment;

public class UnionPay extends Payment {
    @Override
    public String getName() {
        return "Union Pay";
    }

    @Override
    protected double queryBalance(String uid) {
        return 120;
    }
}
