package factorypattern.FactoryMethod;


import factorypattern.Course;
import factorypattern.JavaCourse;

public class JavaCourseFactory implements CourseFactory {
    @Override
    public Course create() {
        return new JavaCourse();
    }
}
