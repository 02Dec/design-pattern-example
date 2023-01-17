package creational.builder;

import java.util.Date;

public class Song {
    private String author;
    private String title;
    private String singer;
    private Date publishedAt;

    public Song(String author, String title, String singer, Date publishedAt) {
        super();
        this.author = author;
        this.title = title;
        this.singer = singer;
        this.publishedAt = publishedAt;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    @Override
    public String toString() {
        return "Song{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", singer='" + singer + '\'' +
                ", publishedAt=" + publishedAt +
                '}';
    }
}
