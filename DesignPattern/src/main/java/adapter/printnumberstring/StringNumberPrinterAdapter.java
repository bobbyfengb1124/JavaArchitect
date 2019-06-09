package adapter.printnumberstring;

public class StringNumberPrinterAdapter implements IStringNumberPrinterAdapter {
    @Override
    public String printBinaryString(int i) {
        return processPrintString(i, BinaryPrinterAdapter.class);
    }

    @Override
    public String printHexString(int i) {
        return processPrintString(i, HexPrinterAdapter.class);
    }

    private String processPrintString(int i, Class<? extends StringPrinterAdapter> adapterClass) {
        try {
            StringPrinterAdapter adapter = adapterClass.newInstance();
            if (adapter.support(adapter)) {
                return adapter.print(i);
            } else {
                return null;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }
}
