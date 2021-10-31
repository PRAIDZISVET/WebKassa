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

