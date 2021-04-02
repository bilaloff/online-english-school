package com.english.dao;

import com.english.model.blog.Comment;

import java.util.List;

public interface CommentDao extends BaseDao<Comment> {
    List<Comment> findByPostId(long postId);
}
