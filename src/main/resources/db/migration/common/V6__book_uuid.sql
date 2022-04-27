create table book_uuid (
                id binary(16) not null,
                isbn varchar (255),
                title varchar (255),
                author varchar (255),
                number_of_pages INT,
                primary key(id)
) engine = InnoDB;