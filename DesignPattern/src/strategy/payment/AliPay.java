package strategy.payment;

public class AliPay extends Payment {
    @Override
    public String getName() {
        return "Alipay";
    }

    @Override
    protected double queryBalance(String uid) {
        return 900;
    }
}
