package observer.assignment;

public class GPer {
    private static GPer gPer = null;
    private String name = "GPer BBS";

    public GPer() {
    }

    public static GPer getInstance() {
        if (gPer == null) {
            gPer = new GPer();
        }
        return gPer;
    }

    public String getName() {
        return name;
    }

}
