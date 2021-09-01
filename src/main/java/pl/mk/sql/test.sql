CREATE DATABASE Test;
USE Test;
SELECT @@character_set_database, @@collation_database;
USE preworksql;
show tables;
SELECT @@character_set_database, @@collation_database;
SHOW CREATE TABLE marks;
USE test;
CREATE TABLE test1 (id int AUTO_INCREMENT, testFirstNames VARCHAR(200), PRIMARY KEY(id));
SHOW CREATE TABLE test1;
CREATE TABLE test2 (id2 int AUTO_INCREMENT, test2FirstNames VARCHAR(250), PRIMARY KEY(id2)) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
SHOW CREATE TABLE test2;
CREATE TABLE test3 (id3 int AUTO_INCREMENT, test3FirstNames VARCHAR(250), PRIMARY KEY(id3)) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
SHOW CREATE TABLE test3;
INSERT INTO test3 VALUES (null,'name 1');
SHOW TABLE STATUS like 'test3';

SELECT TABLE_SCHEMA
     , TABLE_NAME
     , TABLE_COLLATION
FROM INFORMATION_SCHEMA.TABLES
WHERE TABLE_NAME = 'test3';
SELECT TABLE_SCHEMA
     , TABLE_NAME
     ,   COLUMN_NAME
     , COLLATION_NAME
FROM INFORMATION_SCHEMA.COLUMNS
WHERE TABLE_NAME = 'test3';

ALTER TABLE test3 COLLATE utf8mb4_unicode_ci;
INSERT INTO test3 VALUES (null,'name 2');
INSERT INTO test3 VALUES (null,'Wojtek');

SHOW FULL COLUMNS FROM test3;

ALTER TABLE test3 COLLATE utf8mb4_0900_ai_ci;

ALTER TABLE test3 CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

EXPLAIN INSERT INTO test3 VALUES (null,'Marek');
SELECT * FROM test3;
EXPLAIN SELECT * FROM test3 ORDER BY test3FirstNames;  # using filesort
EXPLAIN SELECT * FROM test3 WHERE test3FirstNames = 'name 2' ;
EXPLAIN SELECT * FROM test3 WHERE test3FirstNames = 'name 2' ORDER BY test3FirstNames;  # testing usage of filesort
