package strategy.payment;

public abstract class Payment {
    public abstract String getName();

    protected abstract double queryBalance(String uid);

    public PayState pay(String uid, double amount) {
        if (queryBalance(uid) < amount) {
            return new PayState(500, "Payment Failed", "Insufficient Balance.");
        }
        return new PayState(200, "Payment Successful", "Total: " + amount);
    }
}
