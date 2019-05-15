create table if not exists people(
pid integer identity primary key ,
username varchar(50) not null ,
sex      varchar(50) not null
);

insert into people(username, sex) values ('good', 'nv');