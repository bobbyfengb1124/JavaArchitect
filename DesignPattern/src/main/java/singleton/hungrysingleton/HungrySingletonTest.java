package singleton.hungrysingleton;

public class HungrySingletonTest {

    public static void main(String[] args) {

        HungrySingleton iHungrySingleton1 = HungrySingleton.getInstance();
        HungrySingleton iHungrySingleton2 = HungrySingleton.getInstance();

        System.out.println(iHungrySingleton1 + " " + iHungrySingleton2);
    }

}
