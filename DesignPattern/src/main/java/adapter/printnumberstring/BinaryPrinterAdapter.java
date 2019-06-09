package adapter.printnumberstring;

public class BinaryPrinterAdapter extends StringPrinter implements StringPrinterAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof BinaryPrinterAdapter;
    }

    @Override
    public String print(int num) {
        int i = Integer.valueOf(Integer.toBinaryString(num));
        return super.IntegerToString(i);
    }
}
