package adapter.poweradapter;

public class PowerAdapter implements DC5 {
    private AC220 ac220;

    public PowerAdapter(AC220 ac220) {
        this.ac220 = ac220;
    }

    @Override
    public int outputDC5V() {
        int adapterInput = ac220.outputAC220V();

        int adapterOutput = adapterInput / 44;
        System.out.println("use PowerAdpter input AC: " + adapterInput + "V" + " Output DC: " + adapterOutput + "V");

        return adapterOutput;
    }
}
