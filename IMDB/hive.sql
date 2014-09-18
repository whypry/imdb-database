-- 1 a
CREATE TABLE old (m_id int, m_name string, m_year tinyint, m_rating decimal, c_pid int, c_mid int, c_role string, a_id int, a_fname string, a_lname string, a_gender string);
CREATE TABLE new (m_id int, m_name string, m_year tinyint, m_rating decimal, c_pid int, c_mid int, c_role string, a_id int, a_fname string, a_lname string, a_gender string);


INSERT INTO TABLE old
SELECT *
FROM 
movie join cast1 on cast1.m_id = movie.id join actor on cast1.p_id = actor.id
WHERE
movie.year >= 1850 AND movie.year <= 1900;

INSERT INTO TABLE new
SELECT *
FROM
movie join cast1 on cast1.m_id = movie.id join actor on cast1.p_id = actor.id
WHERE
movie.year >= 1901 AND movie.year <= 1950;

Select
distinct old.a_fname, old.a_lname
FROM
old join new on old.a_id = new.a_id;
-- WHERE
-- old.m_year >= 1850 AND old.m_year <= 1900 AND new.m_year >= 1901 AND new.m_year <= 1950;

DROP TABLE old;
DROP TABLE new;

-- 1 b
SELECT
director.fname, director.lname
FROM
director JOIN movie_director ON director.id = movie_director.did JOIN movie ON movie.id = movie_director.mid
WHERE 
movie.year % 4 = 0 AND movie.year % 100 != 0 OR movie.year % 400 = 0;

-- 2
CREATE view if not exists shrek 
as
select * from movie
where movie.name = "Shrek (2001)"

SELECT movie.name
FROM 
movie JOIN shrek on movie.year = shrek.year
WHERE 
movie.rating > shrek.rating;

-- 3
SELECT
actor.fname as ActorFirstName,
actor.lname as ActorLastName
FROM
cast1 JOIN movie on cast1.m_id = movie.id JOIN actor on cast1.p_id = actor.id 
WHERE
movie.name = 'Officer 444 (1926)';

-- 4
select
movie_director.did,
count(Distinct movie_director.mid) AS movie_count
FROM
movie_director
GROUP BY
movie_director.did
ORDER BY
movie_count DESC;

-- 5 a
SELECT
cast1.m_id,
COUNT(Distinct cast1.p_id) AS cast_count
FROM
cast1
GROUP BY cast1.m_id
ORDER BY cast_count DESC
LIMIT 1;

-- 5 b
SELECT
cast1.m_id,
COUNT(Distinct cast1.p_id) AS cast_count
FROM
cast1
WHERE cast1.m_id != NULL
GROUP BY cast1.m_id
ORDER BY cast_count ASC
LIMIT 1;
