package com.english.dao;

import com.english.model.blog.Category;
import com.english.model.blog.Comment;

import java.util.List;

public interface CommentDao extends BaseDao<Category> {
    List<Comment> findByPostId(long postId);
}
