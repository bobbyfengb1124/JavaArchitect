package FactoryPattern.SimpleFactory;

import FactoryPattern.Course;
import FactoryPattern.JavaCourse;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        CourseFactory factory = new CourseFactory();

        Course course = factory.create(JavaCourse.class);
    }
}
