use imdb;

-- select distinct concat(fname, ' ', lname)
-- from cast c inner join actor a on c.pid = a.id
-- inner join movie m on c.mid = m.id
-- where m.year between 1950 and 2000
-- having count(distinct 

-- 1a
SELECT DISTINCT 
    actor.fname AS ActorFirstName, 
    actor.lname AS ActorLastName
FROM 
    actor
    INNER JOIN cast AS OlderCast ON OlderCast.pid = actor.id
    INNER JOIN movie AS OlderMovie ON OlderCast.mid = OlderMovie.id
    INNER JOIN cast AS NewerCast ON NewerCast.pid = actor.id
    INNER JOIN movie AS NewerMovie ON NewerCast.mid = NewerMovie.id
WHERE
    OlderMovie.year >= 1850 
    AND OlderMovie.year <= 1900
    AND NewerMovie.year >= 1901
    AND NewerMovie.year <= 1950;

-- 1b
SELECT
	director.fname as DirectorFirstName,
	director.lname as DirectorLastName
FROM
	movie_director
	INNER JOIN director ON movie_director.did = director.id
	INNER JOIN movie ON movie_director.mid = movie.id
WHERE
	MOD(movie.year, 4) = 0
	AND MOD(movie.year, 100) != 0
	AND MOD(movie.year, 400) = 0;

-- 2 (id int(20), name varchar(255), year int(2), rank decimal(2,1)) engine=MyISAM
CREATE TEMPORARY TABLE shrek

SELECT * FROM movie WHERE movie.name = 'Shrek (2001)';

SELECT
	movie.name
FROM
	movie
	INNER JOIN shrek on movie.year = shrek.year
WHERE
	movie.year = shrek.year
	AND movie.rank > shrek.rank;