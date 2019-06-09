package adapter.printnumberstring;

public interface StringPrinterAdapter {
    boolean support(Object adapter);

    String print(int num);
}
