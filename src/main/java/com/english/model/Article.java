package com.english.model;

import java.time.LocalDateTime;

public class Article extends Model {

    private long id;
    private long viewCount;
    private User author;
    private String title;
    private String content;
    private LocalDateTime datePublished;
    private String image;

    public Article() {
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public long getViewCount() {
        return viewCount;
    }

    public void setViewCount(long viewCount) {
        this.viewCount = viewCount;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDateTime datePublished) {
        this.datePublished = datePublished;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
