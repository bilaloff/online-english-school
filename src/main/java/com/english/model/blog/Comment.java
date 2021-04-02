package com.english.model.blog;

import com.english.model.Model;
import com.english.model.User;

import java.util.Date;

public class Comment extends Model {

    private long postId;
    private User user;
    private String comment;
    private Date createdAt;

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long time) {
        this.createdAt = new Date(time);
    }
}
