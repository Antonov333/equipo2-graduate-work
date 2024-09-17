-- liquibase formatted sql

-- changeset vadim:1
CREATE table comments(
    id BIGSERIAL PRIMARY KEY,
    created_at INTEGER,
    text TEXT,
    user_id INTEGER REFERENCES users (id)
)

--changeset antonov333:9
ALTER TABLE comments DROP COLUMN user_id;
ALTER TABLE comments ADD user_id BIGINT;

--changeset antonov333:10
ALTER TABLE comments ADD password TEXT;

--changeset antonov333:11
ALTER TABLE comments DROP COLUMN password;

--changeset antonov333:52
ALTER TABLE comments DROP COLUMN created_at;
ALTER TABLE comments ADD created_at TIMESTAMP;

--changeset antonov333:53
ALTER TABLE comments DROP COLUMN created_at;
ALTER TABLE comments ADD created_at BIGINT;

--changeset antonov333:54
ALTER TABLE comments ADD author_image TEXT;
ALTER TABLE comments ADD author_first_name TEXT;

--changeset antonov333:55
ALTER TABLE comments ADD ad_id BIGINT;