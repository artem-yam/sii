package words.entity;

public class Game {

    private String title;
    private String developer;
    private String publisher;
    private String publishYear;

    public Game() {
    }

    public Game(String title, String developer, String publisher,
                String publishYear) {
        this.title = title;
        this.developer = developer;
        this.publisher = publisher;
        this.publishYear = publishYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }
}
