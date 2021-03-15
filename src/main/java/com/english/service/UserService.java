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

    public void signUpUser(User user) throws ServiceException {
        try {
            if (userDao.findByEmail(user.getEmail()).isEmpty()) {
                userDao.add(user);
            } else {
                throw new ServiceException("auth.email.inUse");
            }
        } catch (DAOException e) {
            throw new ServiceException("error.somethingWentWrong");
        }
    }

    public User signInUser(User user) throws ServiceException {
        try {
            Optional<User> userOptional = userDao.findByEmail(user.getEmail());
            if (userOptional.isPresent()) {
                User foundUser = userOptional.get();
                if (user.getPassword().equals(foundUser.getPassword())) {
                    return foundUser;
                } else {
                    throw new ServiceException("auth.credentials.incorrectPassword");
                }
            } else {
                throw new ServiceException("auth.email.notFound");
            }
        } catch (DAOException e) {
            throw new ServiceException("error.somethingWentWrong");
        }
    }

    public Optional<User> getUserByEmail(String email) throws ServiceException {
        try {
            return userDao.findByEmail(email);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new ServiceException("error.somethingWentWrong");
        }
    }

    public void changePassword(User user) throws ServiceException {
        try {
            if(!user.getNewPassword().equals(user.getNewPasswordRepeat())){
                throw new ServiceException("auth.credentials.passwordsDoNotMatch");
            }
            if(user.getNewPassword().length() < 6){
                throw new ServiceException("auth.password.minLength");
            }
            if(user.getNewPassword().length() > 32){
                throw new ServiceException("auth.password.maxLength");
            }
            if(!userDao.checkPassword(user)){
                throw new ServiceException("auth.credentials.incorrectPassword");
            }
            userDao.changePassword(user);
        } catch (DAOException e){
            throw new ServiceException("error.somethingWentWrong");
        }
    }
}
