package factorypattern.AbstractFactory;

public class AbstractFactoryTest {
    public static void main(String[] args) {

        CourseFactory javaCourseFactoryFactory = new JavaCourseFactory();
        javaCourseFactoryFactory.createCrouse();
        javaCourseFactoryFactory.createNote();
        javaCourseFactoryFactory.createVideo();
    }
}
