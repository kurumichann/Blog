CREATE TABLE user(
    username varchar(20) NOT NULL,
    password varchar(20) NOT NULL,
    gender varchar(5),
    mailaddress varchar(30),
    registertime timestamp NOT NULL,
    authority varchar(20) NOT NULL,
    status  varchar(5) NOT NULL,
    primary key(username)
);