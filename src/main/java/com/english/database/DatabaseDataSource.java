package com.english.database;

import org.apache.log4j.Logger;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DatabaseDataSource {

    private static final Logger LOGGER = Logger.getLogger(DatabaseDataSource.class);
    private static final DatabaseDataSource INSTANCE = new DatabaseDataSource();
    private final BlockingQueue<Connection> connectionQueue;
    private static final String DB_DRIVER = "database.driver";
    private static final String DB_URL = "database.url";
    private static final String DB_USERNAME = "database.username";
    private static final String DB_PASSWORD = "database.password";
    private static final String DB_POOL_SIZE = "database.poolSize";

    private DatabaseDataSource() {
        //ToDO Refactor DatabaseDataSource
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        String driver = System.getenv(resourceBundle.getString(DB_DRIVER));
        String url = System.getenv(resourceBundle.getString(DB_URL));
        String username = System.getenv(resourceBundle.getString(DB_USERNAME));
        String password = System.getenv(resourceBundle.getString(DB_PASSWORD));
        int poolSize = Integer.parseInt(resourceBundle.getString(DB_POOL_SIZE));
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            LOGGER.fatal(e.getMessage(), e);
            System.exit(1);
        }
        connectionQueue = new ArrayBlockingQueue<>(poolSize);
        Connection connection;
        for (int i = 0; i < poolSize; i++) {
            try {
                connection = createConnection(url, username, password);
                connectionQueue.offer(connection);
            } catch (SQLException e) {
                LOGGER.fatal(e.getMessage(), e);
            }
        }
    }

    public static DatabaseDataSource getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = connectionQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void releaseConnection(PooledConnectionWrapper connection) throws SQLException {
        if (!connection.getAutoCommit()) {
            connection.setAutoCommit(true);
        }
        connectionQueue.offer(connection);
    }

    private Connection createConnection(String url, String user, String password) throws SQLException {
        return new PooledConnectionWrapper(DriverManager.getConnection(url, user, password), this);
    }
}
