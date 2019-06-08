package templatemethod.gupaoclass;

public class BigDataCourse extends NetworkCourse {
    private boolean needHomeworkFlag = false;

    public BigDataCourse(boolean needHomeworkFlag) {
        this.needHomeworkFlag = needHomeworkFlag;
    }

    @Override
    void checkHomework() {
        System.out.println("checkging Big Data Course assignment.");
    }

    @Override
    protected boolean needHomework() {
        return this.needHomeworkFlag;
    }
}
