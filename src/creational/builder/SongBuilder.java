package creational.builder;

import java.util.Date;

public class SongBuilder {
    private String author;
    private String title;
    private String singer;
    private Date publishedAt;

    public SongBuilder author(String author) {
        this.author = author;
        return this;
    }

    public SongBuilder title(String title) {
        this.title = title;
        return this;
    }

    public SongBuilder singer(String singer) {
        this.singer = singer;
        return this;
    }

    public SongBuilder publishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
        return this;
    }

    public Song build() {
        return new Song(author, title, singer, publishedAt);
    }
}
