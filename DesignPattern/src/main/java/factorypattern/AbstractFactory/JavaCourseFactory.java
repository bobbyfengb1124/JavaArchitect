package factorypattern.AbstractFactory;

import factorypattern.Course;
import factorypattern.JavaCourse;

public class JavaCourseFactory implements CourseFactory {
    @Override
    public Course createCrouse() {
        return new JavaCourse();
    }

    @Override
    public Note createNote() {
        return new JavaNote();
    }

    @Override
    public Video createVideo() {
        return null;
    }
}
