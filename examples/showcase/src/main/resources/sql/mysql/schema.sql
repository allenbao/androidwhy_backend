drop table if exists aw_user_role;
drop table if exists aw_role;
drop table if exists aw_user;
drop table if exists aw_team;
create table aw_role (
    id bigint auto_increment,
    name varchar(255) not null unique,
    permissions varchar(255),
    primary key (id)
) engine=InnoDB;

create table aw_user (
    id bigint auto_increment,
    login_name varchar(255) not null unique,
    name varchar(64),
    password varchar(255),
    salt varchar(64),
    email varchar(128),
    status varchar(32),
    team_id bigint,
    primary key (id)
) engine=InnoDB;

create table aw_user_role (
    user_id bigint not null,
    role_id bigint not null,
    primary key (user_id, role_id)
) engine=InnoDB;

create table aw_team (
    id bigint auto_increment,
    name varchar(255) not null unique,
    master_id bigint,
    primary key (id)
) engine=InnoDB;


insert into aw_user (id, login_name, name, email, password, salt, status, team_id) values(1,'admin','Admin','admin@androidwhy.com','691b14d79bf0fa2215f155235df5e670b64394cc','7efbd59d9741d34f','enabled',1);
insert into aw_user (id, login_name, name, email, password, salt, status, team_id) values(2,'user','Gordon','user@androidwhy.com','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','enabled',1);
insert into aw_user (id, login_name, name, email, password, salt, status, team_id) values(3,'user2','Jack','jack@androidwhy.com','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','enabled',1);
insert into aw_user (id, login_name, name, email, password, salt, status, team_id) values(4,'user3','Kate','kate@androidwhy.com','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','enabled',1);
insert into aw_user (id, login_name, name, email, password, salt, status, team_id) values(5,'user4','Sawyer','sawyer@androidwhy.com','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','enabled',1);
insert into aw_user (id, login_name, name, email, password, salt, status, team_id) values(6,'user5','Ben','ben@androidwhy.com','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','enabled',1);

insert into aw_role (id, name, permissions) values(1,'Admin','user:view,user:edit');
insert into aw_role (id, name, permissions) values(2,'User','user:view');

insert into aw_user_role (user_id, role_id) values(1,1);
insert into aw_user_role (user_id, role_id) values(1,2);
insert into aw_user_role (user_id, role_id) values(2,2);
insert into aw_user_role (user_id, role_id) values(3,2);
insert into aw_user_role (user_id, role_id) values(4,2);
insert into aw_user_role (user_id, role_id) values(5,2);
insert into aw_user_role (user_id, role_id) values(6,2);

insert into aw_team (id, name, master_id) values(1,'Dolphin',1);
