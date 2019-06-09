package observer.gperdemo;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        GPer gPer = (GPer) o;
        Question question = (Question) arg;
        System.out.println("============================");
        System.out.println("Hi, Lecturer " + name + ", you have received a question from " + gPer.getName() + ". The Question is : " + question.getContent() + "\n");
        System.out.println("Question asked by : " + question.getUsername());
    }
}
