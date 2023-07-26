-- liquibase formatted sql

-- changeset AveryanovV:1.0

create table authors
(
    author_id  bigint not null,
    first_name varchar(255),
    last_name  varchar(255) not null ,
    primary key (author_id)
);

create table book
(
    book_id   bigint not null,
    book_name varchar(255) not null,
    book_year integer,
    count integer,
    author_id bigint,
    primary key (book_id)
);

create table book_genre
(
    book_id  bigint not null,
    genre_id bigint not null
);

create table genre
(
    genre_id   bigint not null,
    genre_name varchar(255) not null,
    primary key (genre_id)
);

alter table book add constraint "FKmxigqo4mngfn81gp30tjjdj58" foreign key (author_id) references authors ;

alter table book_genre add constraint "FK52evq6pdc5ypanf41bij5u218" foreign key (book_id) references book ;

alter table book_genre add constraint "FK8l6ops8exmjrlr89hmfow4mmo" foreign key (genre_id) references genre ;

create sequence authors_seq start with 1 increment by 50;

create sequence book_seq start with 1 increment by 50;

create sequence genre_seq start with 1 increment by 50;

