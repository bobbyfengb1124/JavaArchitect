package factorypattern.AbstractFactory;

import factorypattern.Course;

public class PythonCourseFactory implements CourseFactory {
    @Override
    public Course createCrouse() {
        return null;
    }

    @Override
    public Note createNote() {
        return null;
    }

    @Override
    public Video createVideo() {
        return null;
    }
}
