package strategy.payment;

public class WechatPay extends Payment {
    @Override
    public String getName() {
        return "Wechat Pay";
    }

    @Override
    protected double queryBalance(String uid) {
        return 256;
    }
}
