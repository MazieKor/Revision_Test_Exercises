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

ALTER TABLE test3 ADD (surname VARCHAR(45), address VARCHAR (20));
UPDATE test3 SET surname = 'Kowalski', address = 'Warszawa' where id3 = 1;
UPDATE test3 SET surname = 'NOwak', address = 'Gliwice' where id3 = 2;
UPDATE test3 SET surname = 'Jordan', address = 'Zabrze' where id3 = 3;
UPDATE test3 SET surname = 'Inny', address = 'Gdańsk' where id3 = 4;
UPDATE test3 SET surname = 'Welec', address = 'Bytom' where id3 = 5;

EXPLAIN SELECT * FROM test3 GROUP BY surname;  #temporary table, although GROUP BY not sorting any more (after MySQL 5.7)
EXPLAIN SELECT * FROM test3 WHERE id3 < 4;

ALTER TABLE test3 ADD (columnTEXT3 TEXT(4));   #testing meaning of '()' in TEXT type
ALTER TABLE test3 ADD (columnTINYTEXT3 TINYTEXT);
SELECT @@SESSION.sql_mode;  #checking which mode is set to test behaviour by inserting too big data
SELECT @@GLOBAL.sql_mode;

UPDATE test3 SET columnTEXT3 = 'adąęfgr' WHERE id3 = 2;
UPDATE test3 SET columnTEXT3 = 'adąęcdw sprawdzanie jak długi teskt można wsatwić' WHERE id3 = 3;
UPDATE IGNORE test3 SET columnTINYTEXT3 = 'Testowanie przekroczenia granicy liczby znaków w strict mode TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST TEST ZZZZ 12345678900' WHERE id3 = 5;   #can't insert 255 characters - too long, unless add IGNORE


CREATE INDEX indVarChar ON test3(surname); # testing 2 + this commit I make local
CREATE INDEX indIndex ON test3(columnTINYTEXT3); # for TEXT and BLOB I must give length of index

CREATE TABLE orders (id INT NOT NULL AUTO_INCREMENT, contentOfOrder VARCHAR(100), customerId INT NOT NULL, PRIMARY KEY (id), FOREIGN KEY (customerId) REFERENCES test3(id3) ON DELETE CASCADE);

INSERT INTO orders VALUES (null, 'ball', 3);
INSERT INTO orders VALUES (null, 'bed', 5);
INSERT INTO orders VALUES (null, 'comic book', 3);
INSERT INTO orders VALUES (null, 'book', 1);
INSERT INTO orders VALUES (null, 'knife', 4);
INSERT IGNORE INTO orders VALUES (null, 'sweater', 7);  #can't do, but no error
INSERT INTO orders VALUES (null, 'newspaper', 3);
INSERT INTO orders VALUES (null, 'ticket', 3);
INSERT INTO orders VALUES (null, 'magazine', 3);
INSERT INTO orders VALUES (null, 'bread', 2);
INSERT INTO orders VALUES (null, 'cheese', 3);
INSERT INTO orders VALUES (null, 'book 2', 1);
INSERT INTO orders VALUES (null, 'toy2', 3);
INSERT INTO orders(contentOfOrder, customerId) VALUES ('milk', 8);  #can't do, error
INSERT INTO orders VALUES (null, 'milk', 3);
INSERT INTO orders VALUES (null, 'apple', 4);

DELETE FROM orders WHERE id = 27;
DELETE FROM orders WHERE id = 25;
DELETE FROM orders WHERE id = 28;
DELETE FROM test3 WHERE id3 = 4;

CREATE TABLE ordersWoCascade (id INT NOT NULL AUTO_INCREMENT, contentOfOrder VARCHAR(100), customerId INT NOT NULL, PRIMARY KEY (id), FOREIGN KEY (customerId) REFERENCES test3(id3));
INSERT INTO ordersWoCascade VALUES (null, 'ball', 3);
INSERT INTO ordersWoCascade VALUES (null, 'bed', 5);
INSERT INTO ordersWoCascade VALUES (null, 'comic book', 3);
INSERT INTO ordersWoCascade VALUES (null, 'book', 1);
INSERT INTO ordersWoCascade VALUES (null, 'apple', 5);
INSERT INTO ordersWoCascade VALUES (null, 'pear', 5);
INSERT INTO ordersWoCascade VALUES (null, 'toy', 1);
DELETE FROM ordersWoCascade WHERE id = 3;
DELETE FROM ordersWoCascade WHERE id = 5;
DELETE FROM test3 WHERE id3 = 5;  # can't do it without 'ON DELETE CASCADE'
DELETE FROM ordersWoCascade WHERE id = 2;
DELETE FROM ordersWoCascade WHERE id = 6;
DELETE FROM test3 WHERE id3 = 5;  # now I can delete (no records in children table)

SELECT * FROM orders WHERE customerId = 3 LIMIT 2 OFFSET 1;
EXPLAIN SELECT * FROM orders GROUP BY customerId;

INSERT INTO orders VALUES (null, 'ball', 2);
INSERT INTO orders VALUES (null, 'bed', 3);
INSERT INTO orders VALUES (null, 'comic book', 1);
INSERT INTO orders VALUES (null, 'book', 2);
INSERT INTO orders VALUES (null, 'book', 2);
INSERT INTO orders VALUES (null, 'book', 2);
INSERT INTO orders VALUES (null, 'ball', 2);
INSERT INTO orders VALUES (null, 'poster', 2);

EXPLAIN SELECT * FROM orders GROUP BY contentOfOrder;   # using temporary, not sorted
EXPLAIN SELECT * FROM orders GROUP BY customerId;       # using index, sorted