use imdb;

CREATE TABLE director (id int(20), fname varchar(255), lname varchar(255));

LOAD DATA LOCAL INFILE '/Users/simon_zhang/Downloads/IMDB/director.txt' INTO TABLE director FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' IGNORE 1 LINES (id, fname, lname);

select * from director limit 100;
