create database webkassa_rpository;

create table users
(
    id bigserial
        constraint users_pk
            primary key,
    name varchar(50),
    login varchar(50) not null,
    password varchar(8) not null,
    role_id int not null
);

create unique index users_login_uindex
    on users (login);

create table roles
(
    id serial
        constraint roles_pk
            primary key,
    name varchar(50) not null
);

create unique index roles_name_uindex
    on roles (name);



create table workplaces
(
    id bigserial
        constraint workplaces_pk
            primary key,
    code bigint not null,
    name varchar(50),
    address varchar(100)
);

create unique index workplaces_code_uindex
    on workplaces (code);

create table opers
(
    id bigserial not null,
    name varchar(50) not null,
    isactive boolean not null
);

create unique index opers_id_uindex
    on opers (id);

alter table opers
    add constraint opers_pk
        primary key (id);

