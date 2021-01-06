package com.english.dao;

import com.english.model.User;

import java.util.Optional;

public interface UserDao extends BaseDao<User> {
    Optional<User> findByEmail(String email);
}
