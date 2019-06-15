package summary.didemo;

public class MyMessageDITest {
    public static void main(String[] args) {
        String msg = "Hi Bob";
        String email = "bobfeng@gmail.com";
        String phone = "12345678";
        MessageServiceInjector injector = null;
        Consumer app = null;

        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, email);

        injector = new SMSServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, phone);
    }
}
