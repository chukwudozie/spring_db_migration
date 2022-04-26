drop table if exists book;
drop table if exists author;

create table book (
                id IDENTITY not null,
                author varchar(255),
                isbn varchar(255),
                number_of_pages integer not null,
                title varchar(255),
                author_id bigint,
                primary key (id)
);

create table author (
                id IDENTITY not null,
                first_name varchar(255),
                last_name varchar(255),
                age int,
                books_referenced bigint,
                primary key (id)
);