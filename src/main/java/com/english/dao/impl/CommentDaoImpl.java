package com.english.dao.impl;

import com.english.dao.CommentDao;
import com.english.dao.DAOException;
import com.english.database.DatabaseDataSource;
import com.english.model.User;
import com.english.model.blog.Comment;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommentDaoImpl implements CommentDao {

    private static final String SELECT_COMMENTS = "SELECT * FROM comments_view WHERE post_id = ?";
    private static final String ADD_COMMENT = "INSERT INTO post_comments (post_id, user_id, comment) VALUES (?,?,?)";
    private static final Logger LOGGER = Logger.getLogger(CommentDaoImpl.class);
    private final DatabaseDataSource dataSource = DatabaseDataSource.getInstance();

    @Override
    public Optional<Comment> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Comment> findAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(Comment entity) throws DAOException {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(ADD_COMMENT);
            statement.setLong(1, entity.getPostId());
            statement.setLong(2, entity.getUser().getId());
            statement.setString(3, entity.getComment());
            statement.execute();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            throw new DAOException(e.getMessage(), e);
        }
    }

    @Override
    public void update(Comment entity) {

    }

    @Override
    public void delete(Comment entity) {

    }

    @Override
    public List<Comment> findByPostId(long postId) {
        List<Comment> comments = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SELECT_COMMENTS);
            statement.setLong(1, postId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Comment comment = new Comment();
                User user = new User();

                user.setId(resultSet.getLong("user_id"));
                user.setFirstname(resultSet.getString("firstname"));
                user.setLastname(resultSet.getString("lastname"));
                user.setImage(resultSet.getString("user_image"));
                comment.setUser(user);

                comment.setId(resultSet.getLong("comment_id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setCreatedAt(resultSet.getTimestamp("created_at").getTime());

                comments.add(comment);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return comments;
    }
}
