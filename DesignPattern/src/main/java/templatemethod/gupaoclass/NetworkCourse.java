package templatemethod.gupaoclass;

public abstract class NetworkCourse {
    protected final void createCourse() {
        this.postPreResource();

        this.createPPT();

        this.liveVideo();

        this.postNote();

        this.postSource();

        if (needHomework()) {
            checkHomework();
        }
    }

    final void postPreResource() {
        System.out.println("Posting Pre Course Material");
    }

    final void createPPT() {
        System.out.println("Creating PPT");
    }

    final void liveVideo() {
        System.out.println("Streaming Video");
    }

    final void postNote() {
        System.out.println("Post Notes and PPT");
    }

    final void postSource() {
        System.out.println("Post Demo Code");
    }

    protected boolean needHomework() {
        return false;
    }

    abstract void checkHomework();
}
