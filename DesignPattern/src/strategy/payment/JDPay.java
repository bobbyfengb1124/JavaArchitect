package strategy.payment;

public class JDPay extends Payment {
    @Override
    public String getName() {
        return "JD white note";
    }

    @Override
    protected double queryBalance(String uid) {
        return 500;
    }
}
