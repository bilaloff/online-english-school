package com.english.model.blog;

import com.english.model.Model;
import com.english.model.User;

import java.time.LocalDateTime;

public class Comment extends Model {

    private User user;
    private String comment;
    private LocalDateTime createdAt;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
