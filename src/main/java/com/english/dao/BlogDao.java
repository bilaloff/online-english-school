package com.english.dao;

import com.english.model.blog.Post;

import java.util.List;

public interface BlogDao extends BaseDao<Post> {
    List<Post> getByCategoryName(String categoryName);
}
