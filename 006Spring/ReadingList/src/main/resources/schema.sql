create table if not exists reader(
  username varchar(100) primary key ,
  fullname varchar(50) not null,
  password varchar(200) not null,
);