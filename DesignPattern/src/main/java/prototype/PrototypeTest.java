package prototype;

public class PrototypeTest {

    public static void main(String[] args) {
        try {
            FlyingPig p1 = new FlyingPig("pig1", "12");
            FlyingPig p2 = (FlyingPig) p1.clone();
            for (Leg leg : p2.legs) {
                System.out.println(leg.name);
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
