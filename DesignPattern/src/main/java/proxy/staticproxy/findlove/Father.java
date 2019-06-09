package proxy.staticproxy.findlove;

public class Father implements Person {

    private Son son;

    public Father(Son son) {
        this.son = son;
    }

    @Override
    public void findLove() {
        System.out.println("I am finding a wife for my son.");
        son.findLove();
        System.out.println("If they agree, we can confirm the marriage.");
    }
}
