drop table if exists book;
drop table if exists hibernate_sequence;

create table book (
                      id bigint not null,
                      author varchar(255),
                      isbn varchar(255),
                      number_of_pages integer not null,
                      title varchar(255),
                      primary key (id)
) engine=InnoDB;
create table hibernate_sequence (
    next_val bigint
) engine=InnoDB;
insert into hibernate_sequence values ( 1 );