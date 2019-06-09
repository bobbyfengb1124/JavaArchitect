package templatemethod.gupaoclass;

public class CourseTest {
    public static void main(String[] args) {
        NetworkCourse java = new JavaCourse();
        java.createCourse();

        NetworkCourse bigData = new BigDataCourse(false);
        bigData.createCourse();
    }
}
