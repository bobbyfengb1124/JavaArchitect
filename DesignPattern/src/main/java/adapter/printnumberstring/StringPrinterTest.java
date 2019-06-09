package adapter.printnumberstring;


public class StringPrinterTest {
    public static void main(String[] args) {
        System.out.println("Original Number Printer: " + new StringPrinter().IntegerToString(10));

        IStringNumberPrinterAdapter printer = new StringNumberPrinterAdapter();
        String binString = printer.printBinaryString(10);
        System.out.println("Binary Number Printer: " + binString);

        String hexString = printer.printHexString(10);
        System.out.println("Hex Number Printer: " + hexString);
    }
}
