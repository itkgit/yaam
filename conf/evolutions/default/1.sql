# --- First database schema

# --- !Ups

create table user (
  id                      bigint not null primary key,
  email                   varchar(255) not null unique ,
  name                    varchar(255) not null unique,
  password                varchar(255) not null,
  created_at              timestamp,
  updated_at              timestamp
);

create sequence user_seq start with 1000;

create table event (
  id                      bigint not null primary key,
  name                    varchar(255) not null,
  description             varchar(255) not null,
  date                    date not null,
  start_at                time not null,
  end_at                  time ,
  created_at              timestamp,
  updated_at              timestamp
);

create sequence event_seq start with 1000;

create table attendance (
  id                      bigint not null primary key,
  comment					        varchar(255) not null,
  event                   bigint not null,
  user                    bigint not null,  
  attend_at               time,
  created_at              timestamp,
  updated_at              timestamp,
  foreign key(event)      references event(id) on delete cascade,
  foreign key(user)       references user(id) on delete cascade
);

create sequence attendance_seq start with 1000;

# --- !Downs

drop table if exists attendance;
drop sequence if exists attendance_seq;
drop table if exists event;
drop sequence if exists event_seq;
drop sequence if exists user_seq;
drop table if exists user;