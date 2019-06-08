package adapter.printnumberstring;

public class HexPrinterAdapter implements StringPrinterAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof HexPrinterAdapter;
    }

    @Override
    public String print(int num) {
        return Integer.toHexString(num);
    }
}
