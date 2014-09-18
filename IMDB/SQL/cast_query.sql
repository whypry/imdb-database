
use imdb;
select count(*) from cast;

desc cast;

truncate table cast;

LOAD DATA local INFILE '/Users/simon_zhang/scripts/out/production/IMDB/cast2.txt' INTO TABLE cast FIELDS TERMINATED BY ',' enclosed by "\'" LINES TERMINATED BY '\n' IGNORE 2 LINES (pid, mid, role);



CREATE TABLE cast (p_id int, m_id int, role string) row format delimited fields terminated by "," stored as textfile;

create table table_name (
  id                int,
  dtDontQuery       string,
  name              string
)

select count(*) from cast;

ssh root@simonedice3 head -10 /hadoop/hdfs/data/current/blk_8502421555513986500

map ip addresses to host names
on laptop
