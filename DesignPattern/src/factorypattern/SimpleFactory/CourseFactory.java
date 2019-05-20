package factorypattern.SimpleFactory;

import factorypattern.Course;

public class CourseFactory {
    public Course create(Class<? extends Course> clazz) {

        if(clazz!=null) {
            try {
                return clazz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
