package adapter.poweradapter;

public class AdapterTest {
    public static void main(String[] args) {
        PowerAdapter adapter = new PowerAdapter(new AC220());
        adapter.outputDC5V();
    }
}
