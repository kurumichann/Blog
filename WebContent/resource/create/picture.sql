CREATE TABLE PICTURE(
    content varchar(2000) NOT NULL,
    img varchar(50) NOT NULL,
    createTime timestamp NOT NULL,
    user varchar(10) NOT NULL,
    good int(6),
    id int(10) NOT NULL auto_increment,
    PRIMARY KEY(id)
	
);