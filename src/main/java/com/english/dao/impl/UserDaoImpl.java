package com.english.dao.impl;

import com.english.dao.DAOException;
import com.english.dao.UserDao;
import com.english.database.DatabaseDataSource;
import com.english.model.Student;
import com.english.model.User;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {

    private static final String FIND_USER_BY_EMAIL = "SELECT * FROM users WHERE email = ?";
    private static final String CHECK_PASSWORD = "SELECT * FROM users WHERE id = ? AND password = ?";
    private static final String CHANGE_PASSWORD = "UPDATE users SET password = ? WHERE id = ?";
    private static final String FIND_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String ADD_USER = "INSERT INTO users (email, password, firstname, lastname) VALUES(?,?,?,?)";
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    private final DatabaseDataSource dataSource = DatabaseDataSource.getInstance();
    private static final long USER_ROLE = 2;

    public UserDaoImpl() {
    }

    @Override
    public Optional<User> findById(Long id) throws DAOException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new Student();
                user.setId(resultSet.getShort("id"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstname(resultSet.getString("firstname"));
                user.setLastname(resultSet.getString("lastname"));
                user.setImage(resultSet.getString("image"));
                return Optional.of(user);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void add(User entity) throws DAOException {
        Connection connection = dataSource.getConnection();
        try (connection) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(ADD_USER, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, entity.getEmail());
            statement.setString(2, entity.getPassword());
            statement.setString(3, entity.getFirstname());
            statement.setString(4, entity.getLastname());
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            statement = connection.prepareStatement(ADD_USER_ROLE);
            generatedKeys.next();
            statement.setLong(1, generatedKeys.getLong(1));
            statement.setLong(2, USER_ROLE);
            statement.execute();
            connection.commit();
        } catch (SQLException e) {
            try {
                LOGGER.error(e.getMessage(), e);
                connection.rollback();
            } catch (SQLException exception) {
                exception.initCause(e);
                LOGGER.error(e.getMessage(), exception);
                throw new DAOException(exception.getMessage());
            }
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(DELETE_USER);
            statement.setLong(1, entity.getId());
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new Student();
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
    public void changePassword(User user) throws DAOException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CHANGE_PASSWORD);
            statement.setString(1, user.getNewPassword());
            statement.setLong(2, user.getId());
            statement.execute();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public boolean checkPassword(User user) throws DAOException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(CHECK_PASSWORD);
            statement.setLong(1, user.getId());
            statement.setString(2, user.getPassword());
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            throw new DAOException(e.getMessage());
        }
    }
}
