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
CREATE INDEX indIndex ON test3(columnTINYTEXT3); # for TEXT and BLOB I must give length of index (key is not created)

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
DELETE FROM test3 WHERE id3 = 3;  # can't do it without 'ON DELETE CASCADE'
UPDATE test3 SET  test3FirstNames = 'Michael' WHERE id3 = 3;  # can update
UPDATE test3 SET  id3 = 23 WHERE test3FirstNames = 'Michael';  # can't update primary key
DELETE FROM ordersWoCascade WHERE id = 2;
DELETE FROM ordersWoCascade WHERE id = 6;
DELETE FROM test3 WHERE id3 = 5;  # now I can delete (no records in children table)

ALTER TABLE test1 MODIFY COLUMN testFirstNames VARCHAR(250);
ALTER TABLE test2 ADD FOREIGN KEY(id2) REFERENCES test1(id) ON DELETE CASCADE;
DESC test2;

INSERT INTO test1 VALUES (null, 'Maciek'), (null, 'Wojtek'), (null, 'Iwona'), (null, 'Marek');
INSERT INTO test2 VALUES (2, 'Wojtek'), (4, 'Iwona'), (3, 'Marek');
DELETE FROM test2 WHERE id2 = 3;
DELETE FROM test1 WHERE id = 1;
DELETE FROM test1 WHERE id = 2;
SHOW TABLE STATUS like 'test2';
ALTER TABLE test2 DROP FOREIGN KEY test2_ibfk_2;
ALTER TABLE test2 DROP FOREIGN KEY test2_ibfk_1;

ALTER TABLE test2 ADD CONSTRAINT no_cascade FOREIGN KEY(id2) REFERENCES test1(id);
DELETE FROM test1 WHERE id = 3;
DELETE FROM test1 WHERE id = 4;
DELETE FROM test2 WHERE id2 = 4;
ALTER TABLE test2 DROP CONSTRAINT test2_ibfk_3;
ALTER TABLE test2 DROP CONSTRAINT no_cascade;

ALTER TABLE test2 DROP CONSTRAINT no_cascade, ADD CONSTRAINT cascade2 FOREIGN KEY(id2) REFERENCES test1(id) ON DELETE CASCADE;
ALTER TABLE test2 DROP CONSTRAINT cascade2;

ALTER TABLE test2 ADD booltest BOOL;
INSERT INTO test2 VALUES (null, 'Tom', 1), (null, 'Tom', 2), (null, 'Tom', 0), (null, 'Tom', 23);
SELECT booltest FROM test2 WHERE id2 = 8;

ALTER TABLE test2 ADD booltest2 TINYINT;
ALTER TABLE test2 ADD booltest3 TINYINT(34);
ALTER TABLE test2 ADD booltest4 INT;

INSERT INTO test2 VALUES (null, 'Tom', 1,1,1,1), (null, 'Tom', 2,2,2,2), (null, 'Tom', 0,0,0,0), (null, 'Tom', 23,23,23,23);
INSERT INTO test2 VALUES (null, 'Tom', TRUE, true, true, true), (null, 'Tom', TRUE, FALSE, false, true), (null, 'Tom', FALSE,FALSE,FALSE,FALSE);
SELECT * FROM test2 WHERE test2.booltest2 IS TRUE;


ALTER TABLE test2 ADD bittest BIT;
ALTER TABLE test2 ADD bittest2 BIT(3);
INSERT INTO test2(bittest) VALUES (1);
INSERT INTO test2(bittest2) VALUES (4);
INSERT INTO test2(bittest2) VALUES (12);

SELECT id2, bittest, bittest2 FROM test2 WHERE test2.bittest IS TRUE;
SELECT id2, bittest, bittest2 FROM test2 WHERE test2.bittest IS FALSE;
SELECT id2, bittest, bittest2 FROM test2 WHERE test2.bittest = 0;
SELECT id2, bittest, bittest2 FROM test2 WHERE test2.bittest = 1;
SELECT id2, bittest, bittest2 FROM test2 WHERE test2.bittest2 IS TRUE;
SELECT id2, bittest, bittest2 FROM test2 WHERE test2.bittest2 =4;
SELECT id2, bittest, bittest2 FROM test2 WHERE test2.bittest2 =6;
SELECT id2, bittest, bittest2 FROM test2;


ALTER TABLE test2 DROP COLUMN bittest;



describe orderswocascade;

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

ALTER TABLE orders ADD (testFloat FLOAT(5,2), testDouble DOUBLE, testDouble2 DOUBLE(4,2), testDecimal DECIMAL(5,3));
UPDATE orders SET testFloat = 32.2 WHERE id = 1;
UPDATE orders SET testDouble = 39.2 WHERE id = 1;
UPDATE orders SET testDouble2 = 39 WHERE id = 1;
UPDATE orders SET testDecimal = 32 WHERE id = 1;

UPDATE orders SET testFloat = 11.3456 WHERE id = 2;
UPDATE orders SET testDouble = 39.3456 WHERE id = 2;
UPDATE orders SET testDouble2 = 39.3456 WHERE id = 2;
UPDATE orders SET testDecimal = 32.3456 WHERE id = 2;

UPDATE orders SET testFloat = 999.3456 WHERE id = 3;
UPDATE orders SET testDouble = 999.3456 WHERE id = 3;
UPDATE orders SET testDouble2 = 99.3456 WHERE id = 3;
UPDATE orders SET testDecimal = 99.3456 WHERE id = 3;

UPDATE orders SET testFloat = 999.995 WHERE id = 4;
UPDATE orders SET testDouble = 1000.3456 WHERE id = 4;
UPDATE orders SET testDouble2 = 100 WHERE id = 4;
UPDATE orders SET testDecimal = 99.9995 WHERE id = 4;

UPDATE IGNORE orders SET testFloat = 1000 WHERE id = 17;
UPDATE IGNORE orders SET testDouble = 1000.3456 WHERE id = 17;
UPDATE IGNORE orders SET testDouble2 = 123 WHERE id = 17;
UPDATE IGNORE orders SET testDecimal = 100.12 WHERE id = 17;

UPDATE orders SET testFloat = 1 WHERE id = 18;
UPDATE orders SET testDouble = 1.3456 WHERE id = 18;
UPDATE orders SET testDouble2 = 1 WHERE id = 18;
UPDATE orders SET testDecimal = 1 WHERE id = 18;

UPDATE orders SET testFloat = 67899 WHERE contentOfOrder = 'book234';
UPDATE orders SET testDouble = 12.3456 WHERE contentOfOrder = 18;

ALTER TABLE orders ADD (testCHAR CHAR(4), testVARCHAR VARCHAR(4));
UPDATE orders SET testCHAR = 'test' WHERE id = 1;
UPDATE orders SET testVARCHAR = 'test' WHERE id = 1;
UPDATE orders SET testCHAR = 'uwaga' WHERE id = 2;  # I can't insert, too long
UPDATE orders SET testVARCHAR = 'uwaga' WHERE id = 2;  # I can't insert, too long
UPDATE IGNORE orders SET testCHAR = 'uwaga' WHERE id = 3;  # I can insert, but trucated
UPDATE IGNORE orders SET testVARCHAR = 'uwaga' WHERE id = 3;  # I can insert, but trucated
UPDATE orders SET testCHAR = '汉字汉字' WHERE id = 4;
UPDATE orders SET testVARCHAR = '汉字汉字' WHERE id = 4;
ALTER TABLE orders ADD (testCHAR2 CHAR(255));  #checking maximal character or bytes
UPDATE orders SET testCHAR2 = '汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉' WHERE id = 4;
SELECT CHAR_LENGTH(testCHAR2) FROM orders WHERE id = 4;

ALTER TABLE orders ADD (testVARCHAR2 VARCHAR(255));
UPDATE orders SET testVARCHAR2 = '汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉字汉' WHERE id = 4;
SELECT LENGTH(testVARCHAR2) FROM orders WHERE id = 4;
ALTER TABLE orders ADD (testVARCHAR3 VARCHAR(16380));  # exceeds max row size


DESCRIBE test3;
DESCRIBE orders;
DESCRIBE orderswocascade;

CREATE TABLE orders2 (id INT, customerId INT, PRIMARY KEY (id), FOREIGN KEY (customerId) REFERENCES test3(id3) ON DELETE CASCADE);
DESCRIBE orders2;

CREATE TABLE orders3 (id INT AUTO_INCREMENT, defCheck TEXT DEFAULT('default tekst'), testField CHAR(23) UNIQUE, PRIMARY KEY (id));
DESCRIBE orders3;
INSERT INTO orders3 VALUES(null, null, 'czy działa testField 3');
#INSERT INTO orders3 VALUES(null, , 'czy działa testField 3'); # not possible to use default like this
INSERT INTO orders3(defCheck, testField) VALUES( 'czy działa testField 5'); # not possible to use default like this
INSERT INTO orders3(testField) VALUES('czy działa testField 6');
INSERT INTO orders3(testField) VALUES('czy działa testField 7');
DROP TABLE orders3;

DESCRIBE orders3;

CREATE TABLE orders4 (id INT AUTO_INCREMENT, defCheck TEXT DEFAULT('default tekst'), testField CHAR(23) NOT NULL DEFAULT (null) , PRIMARY KEY (id));
DESCRIBE orders4;
INSERT INTO orders4(defCheck) VALUES('czy działa testField 7');
DROP TABLE orders4;

CREATE TABLE ordersCheckAdding (id INT NOT NULL AUTO_INCREMENT, testFloat FLOAT(4,2), testDouble2 DOUBLE(4,2), testDecimal DECIMAL(4,2), PRIMARY KEY (id));
INSERT INTO ordersCheckAdding(testFloat, testDouble2, testDecimal) VALUES (10.224, 10.224, 10.224), (10.224, 10.224, 10.224), (10.224, 10.224, 10.224);
SELECT SUM(testFloat), SUM(testDouble2), SUM(testDecimal) FROM ordersCheckAdding;
DELETE FROM ordersCheckAdding;
INSERT IGNORE INTO ordersCheckAdding(testFloat, testDouble2, testDecimal) VALUES (10.224, 10.224, 10.224), (10.224, 10.224, 10.224), (10.224, 10.224, 10.224);
SELECT SUM(testFloat), SUM(testDouble2), SUM(testDecimal) FROM ordersCheckAdding;

describe ordersCheckAdding;
ALTER TABLE ordersCheckAdding MODIFY COLUMN id MEDIUMINT;
CREATE TABLE test4 (id INT, testFloat FLOAT(4,2));
describe test4;
ALTER TABLE test4 MODIFY COLUMN id INT, ADD PRIMARY KEY (id);
DROP TABLE test4;

SELECT contentOfOrder, customerId FROM orders;
SELECT DISTINCT contentOfOrder, customerId FROM orders;

CREATE TABLE testFunctions (id INT, test1 INT, test2 INT, test3 INT, test4 DECIMAL(4,2));
DESC testFunctions;
ALTER TABLE testFunctions MODIFY COLUMN id INT AUTO_INCREMENT, ADD PRIMARY KEY (id);
INSERT INTO testFunctions VALUES (null, 2, 3, 4, 5);
INSERT INTO testFunctions VALUES (null, 2, 3, 47, 5);
INSERT INTO testFunctions VALUES (null, 2, 3, 50, 8);
INSERT INTO testFunctions (test1, test2, test3) VALUES (16, 31, 4);
INSERT INTO testFunctions (test1, test3, test4) VALUES (2, 3, 4);
INSERT INTO testFunctions (test1, test3, test4) VALUES (2.4, 3, 4);
INSERT INTO testFunctions (test1, test3, test4) VALUES ('red', 3, 4);
DELETE FROM testFunctions where id = 12;

SELECT DISTINCT test2 FROM testFunctions;
SELECT COUNT(id) FROM testFunctions;  #some tests on Count and AVG with nulls
SELECT COUNT(test1) FROM testFunctions;
SELECT COUNT(test2) FROM testFunctions;
SELECT COUNT(test3) FROM testFunctions;
SELECT COUNT(test4) FROM testFunctions;
SELECT COUNT(*) FROM testFunctions;
SELEct SUM(test1) FROM testFunctions;
SELEct SUM(test2) FROM testFunctions;
SELEct SUM(test3) FROM testFunctions;
SELEct SUM(test4) FROM testFunctions;
SELECT AVG(test1) FROM testFunctions;
SELECT AVG(test2) FROM testFunctions;
SELECT AVG(test3) FROM testFunctions;
SELECT AVG(test4) FROM testFunctions;

SELECT test2, COUNT(*) FROM testFunctions GROUP BY test2;
SELECT test2, COUNT(test2) FROM testFunctions GROUP BY test2;
EXPLAIN SELECT DISTINCT test1 FROM testFunctions;   #comparing distinct and group by (both 'using temporary)
EXPLAIN SELECT test1 FROM testFunctions GROUP BY test1;
EXPLAIN SELECT test1, SUM(test1) FROM testFunctions GROUP BY test1;

INSERT INTO testFunctions VALUES (null, 2, 3, 50, 8);
INSERT INTO testFunctions VALUES (null, 2, 3, 50, 8);
DELETE FROM testFunctions WHERE id = 14;
DELETE FROM testFunctions; #id and AUTO_INCREMENT not zeroed

INSERT INTO testFunctions SET id=29, test1=2600, test2=23, test3 = test2, test4 = 67.9;
INSERT INTO testFunctions VALUES (19, 6000, 3, 50, 8);
DESC orders4;
CREATE TABLE orders4 (id INT, customerId INT UNIQUE, PRIMARY KEY (id), FOREIGN KEY (customerId) REFERENCES test3(id3) ON DELETE CASCADE);

SELECT DATE_FORMAT(CURDATE(), '%W   %e   %Y');
CREATE TABLE test4(id INT AUTO_INCREMENT, datetime DATETIME, timestamp TIMESTAMP, PRIMARY KEY (id));
INSERT INTO test4 VALUES (null, '2012-11-11', '2021-11-11');
INSERT INTO test4 VALUES (null, 20131121, 20220709);
INSERT INTO test4 VALUES (null, 20131121, 20220709221121);
INSERT INTO test4 VALUES (null, '2010-01-01', '2010-01-01');
SELECT FORMAT(DATEDIFF(datetimeC, timestampC),'de_DE') FROM test4 WHERE id = 3;
SELECT TIMEDIFF(datetimeC, timestampC) FROM test4 WHERE id = 3;
SELECT SUBTIME(datetimeC, timestampC) FROM test4;
ALTER TABLE test4 RENAME COLUMN datetime TO datetimeC;
ALTER TABLE test4 RENAME COLUMN timestamp TO timestampC;
ALTER TABLE test4 ADD datetimeC2 DATETIME;
INSERT INTO test4 VALUES (null, '2010-01-01', '2010-01-01', '2010-01-01');
INSERT INTO test4 VALUES (null, '2010-01-01', '2010-01-01', '2010-01-03');
SELECT ADDTIME(datetimeC, datetimeC2) FROM test4 WHERE id = 6;
SELECT TIMEDIFF(datetimeC, datetimeC2) FROM test4 WHERE id = 4;
INSERT INTO test4 VALUES (null, '2010-01-01 12:30:00', '2010-01-01', '2010-01-03');
SELECT SUBTIME(datetimeC, datetimeC2) FROM test4 WHERE id = 7;
INSERT INTO test4 VALUES (null, '2010-01-01 12:30:00', '2010-01-01', '2010-01-03');
SELECT SUBDATE(datetimeC2, 23) FROM test4;
INSERT INTO test4 VALUES (null, '2010-01-01 12:30:00', '2010-01-01', '2010-01-03 11:30:00');
SELECT SUBTIME('2010-01-01 12:30:00.0', '2010-01-01') FROM test4 WHERE id = 8;
SELECT @@GLOBAL.time_zone;
SELECT @@session.time_zone;
SET @@session.time_zone = '+00:00';
SELECT CURTIME();
SELECT NOW();
SELECT LOCALTIME();
SELECT UTC_TIME();
SELECT SYSDATE();