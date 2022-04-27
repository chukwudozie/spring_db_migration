create table book_natural (
            title varchar(255) not null,
            author varchar(255),
            isbn varchar(255),
            primary key (title)
) engine= InnoDB;