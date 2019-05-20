package factorypattern.FactoryMethod;

import factorypattern.Course;
import factorypattern.PythonCourse;

public class PythonCourseFactory implements CourseFactory {
    @Override
    public Course create() {
        return new PythonCourse();
    }
}
