package com.english.service.impl;

import com.english.dao.DAOException;
import com.english.dao.UserDao;
import com.english.dao.impl.UserDaoImpl;
import com.english.model.User;
import com.english.service.ServiceException;
import com.english.service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    public UserServiceImpl() {
    }

    @Override
    public void signUpUser(User user) throws ServiceException {
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

    @Override
    public User signInUser(User user) throws ServiceException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<User> getUserByEmail(String email) throws ServiceException {
        return userDao.findByEmail(email);
    }
}
