CREATE TABLE music(
    title varchar(30) NOT NULL,
    description varchar(200),
    img varchar(100),
    src varchar(100) NOT NULL,
    createtime timestamp NOT NULL,
    comment varchar(500),
    author varchar(20) NOT NULL,
    id int(10) NOT NULL auto_increment,
    PRIMARY KEY(id) 
	
);