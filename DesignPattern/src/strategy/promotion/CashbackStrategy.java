package strategy.promotion;

public class CashbackStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("Cashback Promotion, the cashback will be transferred to Alipay account.");
    }
}
