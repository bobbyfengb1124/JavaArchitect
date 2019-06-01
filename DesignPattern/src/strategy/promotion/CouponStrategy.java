package strategy.promotion;

public class CouponStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("Get the coupon, the course price will be reduced based on the coupon value.");
    }
}
