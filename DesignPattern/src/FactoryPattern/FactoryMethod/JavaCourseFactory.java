package FactoryPattern.FactoryMethod;


import FactoryPattern.Course;
import FactoryPattern.JavaCourse;

public class JavaCourseFactory implements CourseFactory {
    @Override
    public Course create() {
        return new JavaCourse();
    }
}
