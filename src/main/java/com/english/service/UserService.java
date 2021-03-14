package com.english.service;

import com.english.dao.DAOException;
import com.english.dao.UserDao;
import com.english.dao.impl.UserDaoImpl;
import com.english.model.User;

import java.util.Optional;

public class UserService {

    private final UserDao userDao = new UserDaoImpl();

    public UserService() {
    }

    public void signUp(User user) throws ServiceException {
        if (userDao.findByEmail(user.getEmail()).isEmpty()) {
            try {
                userDao.add(user);
            } catch (DAOException e) {
                throw new ServiceException("error.somethingWentWrong");
            }
        } else {
            throw new ServiceException("auth.email.inUse");
        }
    }

    public User signIn(User user) throws ServiceException {
        if (userDao.findByEmail(user.getEmail()).isEmpty()) {
            try {
                userDao.add(user);
            } catch (DAOException e) {
                throw new ServiceException("error.somethingWentWrong");
            }
        } else {
            throw new ServiceException("auth.email.inUse");
        }
        return null;
    }

    public Optional<User> getUserByEmail(String email) throws ServiceException {
        return userDao.findByEmail(email);
    }

}
