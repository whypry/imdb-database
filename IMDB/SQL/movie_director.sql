use imdb;

CREATE TABLE movie_director (did int(20), mid int(20));

LOAD DATA LOCAL INFILE '/Users/simon_zhang/Downloads/IMDB/movie_director.txt' INTO TABLE movie_director FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' IGNORE 1 LINES (did, mid);

SELECT * from movie_director limit 100;
