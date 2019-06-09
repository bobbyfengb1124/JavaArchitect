package factorypattern.SimpleFactory;

import factorypattern.Course;
import factorypattern.JavaCourse;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        CourseFactory factory = new CourseFactory();

        Course course = factory.create(JavaCourse.class);
    }
}
