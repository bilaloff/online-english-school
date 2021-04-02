package com.english.dao;

import com.english.model.blog.Comment;

import java.util.List;

public interface CommentDao extends BaseDao<Comment> {
    List<Comment> findCommentsByPostId(long postId);
}
