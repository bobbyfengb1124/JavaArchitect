package strategy.payment;

public class PayState {
    private int returnCode;
    private Object data;
    private String msg;

    public PayState(int returnCode, String msg, Object reason) {
        this.returnCode = returnCode;
        this.data = reason;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "PayState{" +
                "returnCode=" + returnCode +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
