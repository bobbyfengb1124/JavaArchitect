package observer.assignment;

import com.google.common.eventbus.Subscribe;

public class GuavaTeacher {
    private String name;

    public GuavaTeacher(String name) {
        this.name = name;
    }

    @Subscribe
    public void update(Object arg) {
        GuavaGperEvent event = (GuavaGperEvent) arg;
        System.out.println("============================");
        System.out.println("Hi, Lecturer " + name +
                ", you have received a question from "
                + event.getgPer().getName() + ". " +
                "The Question is : " +
                event.getQuestion().getContent() + "\n");

        System.out.println("Question asked by : " + event.getQuestion().getUsername());

    }

    public String getName() {
        return this.name;
    }
}
