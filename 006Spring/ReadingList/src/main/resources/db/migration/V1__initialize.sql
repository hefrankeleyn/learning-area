create table if not exists reader(
  username varchar(100) primary key ,
  fullname varchar(50) not null,
  password varchar(200) not null
);

create table if not exists book(
   id integer identity primary key ,
   author varchar(100) not null ,
   title  varchar(100) not null ,
   isbn   varchar(100) not null ,
   description varchar(500) not null,
   reader varchar(100) not null,
   foreign key (reader) references READER(USERNAME)
);
