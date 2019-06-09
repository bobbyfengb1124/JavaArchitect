package factorypattern.AbstractFactory;

import factorypattern.Course;

public interface CourseFactory {

    Course createCrouse();

    Note createNote();

    Video createVideo();

}
