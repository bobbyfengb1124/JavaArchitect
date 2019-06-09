package observer.guava;

import com.google.common.eventbus.Subscribe;

public class GuavaEvent {
    @Subscribe
    public void subscribe(String string) {
        System.out.println("Execute subscribe method, parameter is: " + string);
    }
}
