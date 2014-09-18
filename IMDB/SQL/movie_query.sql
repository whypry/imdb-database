use imdb;

truncate table movie;

LOAD DATA LOCAL INFILE '/Users/simon_zhang/scripts/IMDB/movie1.txt' INTO TABLE movie FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' IGNORE 1 LINES (id, name, year, rank);
