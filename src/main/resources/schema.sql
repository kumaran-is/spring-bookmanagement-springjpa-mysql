DROP TABLE IF EXISTS book;

CREATE TABLE BOOK
(
  ID int  NOT NULL AUTO_INCREMENT,
  NAME varchar(50) NOT NULL, 
  ISBN varchar(50) NOT NULL, 
  AISLE int NOT NULL,
  AUTHOR varchar(50)  NOT NULL, 
  CREATED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,  
  PRIMARY KEY (ID)
);
