package com.english.dao;

import com.english.model.User;

import java.util.Optional;

public interface UserDao extends BaseDao<User> {
    Optional<User> findByEmail(String email) throws DAOException;

    void changePassword(User user) throws DAOException;

    boolean checkPassword(User user) throws DAOException;
}
