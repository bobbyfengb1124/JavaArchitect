package FactoryPattern.AbstractFactory;

import FactoryPattern.Course;

public interface CourseFactory {

    Course createCrouse();

    Note createNote();

    Video createVideo();

}
