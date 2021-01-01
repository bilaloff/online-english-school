package com.english.database;

import java.util.ResourceBundle;

class DatabaseResourceManager {

    private static final DatabaseResourceManager INSTANCE = new DatabaseResourceManager();
    private final ResourceBundle databaseBundle = ResourceBundle.getBundle("database");

    private DatabaseResourceManager() {
    }

    public static DatabaseResourceManager getInstance() {
        return INSTANCE;
    }

    public String getProperty(String key) {
        return databaseBundle.getString(key);
    }
}
