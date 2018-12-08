---
project-create-time: 2018.12.7
---

# init sql
create table students(
    id varchar(50) primary key,
    sname varchar(100) not null,
    birthday varchar(10) not null,
    createdAt bigint not null,
    updatedAt bigint not null,
    version bigint not null
)engine=innodb;
