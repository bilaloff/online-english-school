package com.english.service;

import com.english.model.User;

import java.util.Optional;

public interface UserService {

    void signUpUser(User user) throws ServiceException;
    User signInUser(User user) throws ServiceException;
    Optional<User> getUserByEmail(String email) throws ServiceException;
}
