use imdb;

create table actor (id int(20), lname varchar(255), fname varchar(255), gender varchar(2));

LOAD DATA local INFILE '/Users/simon_zhang/scripts/out/production/IMDB/cast2.txt' INTO TABLE actor FIELDS TERMINATED BY ',' enclosed by "\'" LINES TERMINATED BY '\n' IGNORE 1 LINES (id, fname, lname, gender);
