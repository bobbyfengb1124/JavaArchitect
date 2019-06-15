package observer.assignment;

import com.google.common.eventbus.EventBus;
import observer.gperdemo.Question;

public class GuavaGperTest {
    public static void main(String[] args) {
        Question question = new Question();
        question.setUsername("Mic");
        question.setContent("Why do we use Spring framework?");

        GuavaTeacher tom = new GuavaTeacher("Tom");
        GuavaGperEvent event = new GuavaGperEvent(GPer.getInstance(), question);

        EventBus eventBus = new EventBus();
        eventBus.register(tom);
        eventBus.post(event);
    }
}
