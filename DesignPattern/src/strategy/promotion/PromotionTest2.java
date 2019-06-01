package strategy.promotion;

public class PromotionTest2 {
    public static void main(String[] args) {
        PromotionActivity promotionActivity = null;

        String promotionKey = "COUPON";

        if (promotionKey.equals("COUPON")) {
            promotionActivity = new PromotionActivity(new CouponStrategy());
        } else if (promotionKey.equals("CASHBACK")) {
            promotionActivity = new PromotionActivity(new CashbackStrategy());
        }

        promotionActivity.execute();
    }
}
