package FactoryPattern.FactoryMethod;

import FactoryPattern.Course;
import FactoryPattern.PythonCourse;

public class PythonCourseFactory implements CourseFactory {
    @Override
    public Course create() {
        return new PythonCourse();
    }
}
