package observer.assignment;

import observer.gperdemo.Question;

public class GuavaGperEvent {
    GPer gPer;
    Question question;

    public GuavaGperEvent(GPer source, Question question) {
        this.gPer = source;
        this.question = question;
        System.out.println(question.getUsername() + " submitted a question on " + this.gPer.getName());
    }

    public GPer getgPer() {
        return gPer;
    }

    public Question getQuestion() {
        return question;
    }
}
