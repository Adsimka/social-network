--liquibase formatted sql

--changeset adsimka:1
ALTER TABLE users
ADD COLUMN create_at TIMESTAMP;

--changeset adsimka:2
ALTER TABLE users
ADD COLUMN modified_at TIMESTAMP;

--changeset adsimka:3
ALTER TABLE users
ADD COLUMN created_by VARCHAR(32);

--changeset adsimka:4
ALTER TABLE users
ADD COLUMN modified_by VARCHAR(32);