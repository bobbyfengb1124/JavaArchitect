package observer.gperdemo;

import java.util.Observable;

public class GPer extends Observable {
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

    public void publishQuestion(Question question) {
        System.out.println(question.getUsername() + "submitted a question on " + this.getName());
        setChanged();
        notifyObservers(question);
    }
}
