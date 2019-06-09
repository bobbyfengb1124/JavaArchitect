package factorypattern;

public class JavaCourse implements Course {
    @Override
    public void record() {
        System.out.println("Recording Java...");
    }
}
