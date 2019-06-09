package singleton.hungrysingleton;

public class HungrySingleton {

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
        System.out.println("Im in constructor..and instance vaule is:" + instance);
//		if(instance !=null) {
//			System.out.println("Instance not null");
//		}
//		else {
//			System.out.println("Instance is null");
//		}
    }

    public static HungrySingleton getInstance() {
        return instance;
    }

}
