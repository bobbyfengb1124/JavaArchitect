import java.util.concurrent.ConcurrentHashMap;

public class CHMDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<String,String> chm = new ConcurrentHashMap<>();
        chm.get("asd");
    }
}
