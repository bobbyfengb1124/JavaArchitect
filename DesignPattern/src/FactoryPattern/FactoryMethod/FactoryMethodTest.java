package FactoryPattern.FactoryMethod;


import FactoryPattern.Course;

public class FactoryMethodTest {
    public static void main(String[] args) {
        CourseFactory courseFactory = new JavaCourseFactory();
        Course course = courseFactory.create();
        course.record();
    }
}
