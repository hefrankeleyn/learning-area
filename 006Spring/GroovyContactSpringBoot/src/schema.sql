create table if not exists contacts (
  id identity,
  firstName varchar(30) not null,
  lastName varchar(50) not null,
  phoneNumber varchar(13),
  emailAddress varchar(30)
);