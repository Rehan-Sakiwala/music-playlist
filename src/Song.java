public class Song {
    private String title;
    private double duration;

    public Song(String name, double duration) {
        this.title=name;
        this.duration=duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "title : "+title+"/duration : "+duration;
    }

    //artist
    //genre
}
