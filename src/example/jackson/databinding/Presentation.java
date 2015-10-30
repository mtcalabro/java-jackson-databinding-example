package example.jackson.databinding;

// Do not create an parametrized constructor. Jackson requires an empty constructor

public class Presentation {

    private String date;
    private String time;
    private String presenterName;

    private String presentationTopic;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPresenterName() {
        return presenterName;
    }

    public void setPresenterName(String presenterName) {
        this.presenterName = presenterName;
    }

    public String getPresentationTopic() {
        return presentationTopic;
    }

    public void setPresentationTopic(String presentationTopic) {
        this.presentationTopic = presentationTopic;
    }

    @Override
    public String toString() {

        return "date=" + this.date
                + "time=" + this.time
                + "presenterName=" + this.presenterName
                + "presentorTopic=" + this.presentationTopic;

    }
}
