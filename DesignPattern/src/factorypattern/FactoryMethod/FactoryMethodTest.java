package factorypattern.FactoryMethod;


import factorypattern.Course;

public class FactoryMethodTest {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Course course = courseFactory.create();
        course.record();
    }
}
