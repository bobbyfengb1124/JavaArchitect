package proxy.dynamicproxy.dynamicmeipo;

import proxy.staticproxy.findlove.Person;

public class Customer implements Person {
    @Override
    public void findLove() {
        System.out.println("Handsome");
        System.out.println("180cm tall");
        System.out.println("Six packs");
    }
}
