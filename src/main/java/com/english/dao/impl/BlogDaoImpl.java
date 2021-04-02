package com.english.dao.impl;

import com.english.dao.BlogDao;
import com.english.database.DatabaseDataSource;
import com.english.model.blog.Post;
import com.english.model.User;
import com.english.model.blog.Category;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BlogDaoImpl implements BlogDao {

    private static final String GET_POSTS = "SELECT * FROM posts_view WHERE active = true ORDER BY created_at DESC LIMIT ?,?";
    private static final String FIND_BY_ID = "SELECT * FROM posts_view WHERE active = true AND post_id = ?";
    private static final Logger LOGGER = Logger.getLogger(BlogDaoImpl.class);
    private final DatabaseDataSource dataSource = DatabaseDataSource.getInstance();
    private static final int POSTS_PER_PAGE = 10;

    public List<Post> getArticles(int page) {
        List<Post> posts = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(GET_POSTS);
            statement.setInt(1, page * POSTS_PER_PAGE);
            statement.setInt(2, POSTS_PER_PAGE);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                posts.add(populateArticle(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return posts;
    }

    @Override
    public Optional<Post> findById(Long id) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Optional.of(populateArticle(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Override
    public List<Post> findAll() {
        return null;
    }

    @Override
    public void add(Post entity) {

    }

    @Override
    public void update(Post entity) {

    }

    @Override
    public void delete(Post entity) {

    }

    @Override
    public List<Post> getByCategoryName(String categoryName) {
        return null;
    }

    @Override
    public List<Post> getPopularPosts() {
        List<Post> posts = new ArrayList<>();
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM posts_view ORDER BY views DESC LIMIT 6");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                posts.add(populateArticle(resultSet));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return posts;
    }

    private static Post populateArticle(ResultSet resultSet) throws SQLException {
        Post post = new Post();
        Category category = new Category();
        User author = new User();

        category.setId(resultSet.getLong("category_id"));
        category.setCategory(resultSet.getString("category"));
        post.setCategory(category);

        author.setId(resultSet.getLong("user_id"));
        author.setFirstname(resultSet.getString("user_firstname"));
        author.setLastname(resultSet.getString("user_lastname"));
        author.setImage(resultSet.getString("user_image"));
        post.setAuthor(author);

        post.setId(resultSet.getLong("post_id"));
        post.setTitle(resultSet.getString("title"));
        post.setContent(resultSet.getString("content"));
        post.setImage(resultSet.getString("image"));
        post.setViewCount(resultSet.getLong("views"));
        post.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());
        post.setUpdatedAt(resultSet.getTimestamp("updated_at").toLocalDateTime());

        return post;
    }

    @Override
    public void incrementViewCount(long postId) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE posts SET views = (views + 1) WHERE id = ?");
            statement.setLong(1, postId);
            statement.execute();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
