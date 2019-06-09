package strategy.promotion;

public class GroupbuyStrategy implements PromotionStrategy {
    @Override
    public void doPromotion() {
        System.out.println("Group buying, at least 20 people to form a group. It will be group price.");
    }
}
