package SimpleFactory;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        CourseFactory factory = new CourseFactory();

        Course course = factory.create(JavaCourse.class);
    }
}
