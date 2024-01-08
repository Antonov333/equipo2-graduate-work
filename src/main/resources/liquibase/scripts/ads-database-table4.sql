-- liquibase formatted sql

-- changeset vadimp:1
ALTER TABLE ads
        DROP COLUMN id,
        ADD COLUMN id SERIAL PRIMARY KEY;