package strategy.promotion;

public class EmptyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("No Promotion.");
    }
}
