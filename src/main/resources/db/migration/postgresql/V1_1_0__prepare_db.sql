
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE SCHEMA IF NOT EXISTS hello_world_poc;
DROP TABLE IF EXISTS hello_world_poc.User CASCADE;

CREATE TABLE hello_world_poc.User (
    id BIGSERIAL NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
--    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,

    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    version BIGSERIAL,

    CONSTRAINT user_pk PRIMARY KEY (id),
    CONSTRAINT user_unique_email UNIQUE (email)
);


DROP SEQUENCE IF EXISTS hello_world_poc.user_identifier_seq;
CREATE SEQUENCE hello_world_poc.user_identifier_seq INCREMENT 1;