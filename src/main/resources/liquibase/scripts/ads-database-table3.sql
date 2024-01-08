-- liquibase formatted sql

-- changeset vadimp:3
ALTER TABLE ads ADD COLUMN data BYTEA;
