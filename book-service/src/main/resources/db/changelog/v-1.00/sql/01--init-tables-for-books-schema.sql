drop table if exists books.books cascade;
drop table if exists books.authors cascade;

CREATE TABLE books.authors
(
    id          bigserial primary key,
    created_at  timestamp    NOT NULL,
    modified_at timestamp    NOT NULL,
    first_name  varchar(255) NOT NULL,
    middle_name varchar(255) NULL,
    last_name   varchar(255) NOT NULL
);

CREATE TABLE books.books
(
    id          bigserial primary key,
    created_at  timestamp        NOT NULL,
    modified_at timestamp        NOT NULL,
    name        varchar(255)     NOT NULL,
    genre       varchar(255)     NOT NULL,
    description text             NOT NULL,
    price       numeric          NOT NULL,
    author_id   bigint
);