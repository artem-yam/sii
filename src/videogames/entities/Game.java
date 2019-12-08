package videogames.entities;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private String title;
    private String developer;
    private String publisher;
    private int publishYear;
    private List<String> awards = new ArrayList<>();
    private List<String> tags = new ArrayList<>();

    public Game() {
    }

    public Game(String title, String developer, String publisher,
                int publishYear, List<String> awards,
                List<String> tags) {
        this.title = title;
        this.developer = developer;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.awards = awards;
        this.tags = tags;
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

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public List<String> getAwards() {
        return awards;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override public String toString() {
        return "Game{" +
                "title='" + title + '\'' +
                ", developer='" + developer + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishYear='" + publishYear + '\'' +
                ", awards=" + awards +
                ", tags=" + tags +
                '}';
    }
}
