package observer.gperdemo;


public class ObserverTest {

    public static void main(String[] args) {
        Question question = new Question();
        question.setUsername("asda");
        question.setContent("Why do we use Spring framework?");

        GPer gPer = GPer.getInstance();
        Teacher tom = new Teacher("Tom");
        gPer.addObserver(tom);
        gPer.publishQuestion(question);

    }

}
