package com.english.dao.impl;

import com.english.dao.DAOException;
import com.english.dao.UserDao;
import com.english.database.DatabaseDataSource;
import com.english.model.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private static final String FIND_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
    private static final String FIND_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    private final DatabaseDataSource dataSource = DatabaseDataSource.getInstance();

    public UserDaoImpl() {
    }

    @Override
    public Optional<User> findById(Long id) throws DAOException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getShort("id"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstname(resultSet.getString("firstname"));
                user.setLastname(resultSet.getString("lastname"));
                user.setImage(resultSet.getString("image"));
                return Optional.of(user);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void add(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getShort("id"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstname(resultSet.getString("firstname"));
                user.setLastname(resultSet.getString("lastname"));
                user.setImage(resultSet.getString("image"));
                return Optional.of(user);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

}
