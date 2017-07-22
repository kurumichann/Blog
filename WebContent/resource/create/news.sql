CREATE TABLE NEWS(
    title varchar(30) NOT NULL,
    content varchar(2000) NOT NULL,
    time timestamp NOT NULL,
    author varchar(20) NOT NULL,
    id int(10) NOT NULL auto_increment,
    PRIMARY KEY(id)
);