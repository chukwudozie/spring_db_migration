drop table if exists author;
-- drop table if exists hibernate_sequence;

create table author (
                        id bigint not null,
                        first_name varchar(255),
                        last_name varchar(255),
                        age int,
                        primary key (id)
) engine=InnoDB;

-- The hibernate_sequence table need only to be created once in any of the schemas
-- create table hibernate_sequence (
--     next_val bigint
-- ) engine=InnoDB;
-- insert into hibernate_sequence values ( 1 );