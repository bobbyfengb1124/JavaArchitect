package prototype;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class FlyingPig extends Animal implements Cloneable, Serializable {

    List<Leg> legs;

    public FlyingPig() {
    }

    public FlyingPig(String name, String age) {
        super(name, age);

        legs = Arrays.asList(new Leg("Front Left"), new Leg("Front Right"), new Leg("Back Left"), new Leg("Back Right"));
    }

    public FlyingPig(String name, String age, List<Leg> legs) {
        super(name, age);
        this.legs = legs;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    private Object deepClone() {

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = null;
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            FlyingPig copy = (FlyingPig) ois.readObject();

            return copy;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
