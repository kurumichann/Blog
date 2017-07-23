CREATE TABLE ARTICLE (
    title varchar(30) NOT NULL,
    content varchar(2000) NOT NULL,
    img varchar(50),
    time timestamp NOT NULL,
    author varchar(20) NOT NULL,
    category varchar(10),
    id int(10) NOT NULL auto_increment,
    PRIMARY KEY(id) 
	
);