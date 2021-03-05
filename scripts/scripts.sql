DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS posts;
DROP TABLE IF EXISTS post_categories;
DROP TABLE IF EXISTS post_comments;

CREATE TABLE users
(
    id         INT AUTO_INCREMENT                  NOT NULL UNIQUE PRIMARY KEY,
    email      VARCHAR(64)                         NOT NULL UNIQUE,
    password   VARCHAR(256)                        NOT NULL,
    firstname  VARCHAR(64)                         NOT NULL,
    lastname   VARCHAR(64)                         NOT NULL,
    image      VARCHAR(256),
    verified   BIT       DEFAULT FALSE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE roles
(
    id   INT AUTO_INCREMENT NOT NULL UNIQUE PRIMARY KEY,
    role VARCHAR(32)        NOT NULL
);

CREATE TABLE user_role
(
    user_id INT NOT NULL,
    role_id INT NOT NULL
);

CREATE TABLE posts
(
    id          INT AUTO_INCREMENT                  NOT NULL UNIQUE PRIMARY KEY,
    user_id     INT                                 NOT NULL,
    category_id INT                                 NOT NULL,
    title       VARCHAR(128)                        NOT NULL,
    content     TEXT                                NOT NULL,
    image       VARCHAR(256)                        NOT NULL,
    views       INT       DEFAULT 0,
    active      BIT       DEFAULT FALSE,
    created_at  TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    updated_ad  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE post_categories
(
    id       INT AUTO_INCREMENT NOT NULL UNIQUE PRIMARY KEY,
    category VARCHAR(32)        NOT NULL
);

CREATE TABLE post_comments
(
    id         INT AUTO_INCREMENT NOT NULL UNIQUE PRIMARY KEY,
    post_id    INT                NOT NULL,
    user_id    INT                NOT NULL,
    comment    VARCHAR(512)       NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE user_role
    ADD CONSTRAINT user_role_user_id_users_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE;
ALTER TABLE user_role
    ADD CONSTRAINT user_role_role_id_roles_id FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE;
ALTER TABLE posts
    ADD CONSTRAINT posts_user_id_users_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE;
ALTER TABLE posts
    ADD CONSTRAINT posts_category_id_post_categories_id FOREIGN KEY (category_id) REFERENCES post_categories (id);
ALTER TABLE post_comments
    ADD CONSTRAINT post_comments_post_id_posts_id FOREIGN KEY (post_id) REFERENCES posts (id) ON DELETE CASCADE;
ALTER TABLE post_comments
    ADD CONSTRAINT post_comments_user_id_users_id FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE;