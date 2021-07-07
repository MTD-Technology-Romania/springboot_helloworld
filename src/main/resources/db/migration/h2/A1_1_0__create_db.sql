
create schema if not exists HELLO_WORLD_POC;
CREATE TABLE HELLO_WORLD_POC.User (
    id BIGINT NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,

    created TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    version INT,

    CONSTRAINT user_pk PRIMARY KEY (id),
    CONSTRAINT user_unique_email UNIQUE (email)
);


CREATE SEQUENCE HELLO_WORLD_POC.user_identifier_seq INCREMENT 1;