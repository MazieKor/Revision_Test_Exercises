CREATE DATABASE devExpress CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE TABLE categories (CategoryID int NOT NULL AUTO_INCREMENT, CategoryName varchar(255) NOT NULL,
CategoryDescription varchar(255),PRIMARY KEY (CategoryID));

CREATE TABLE products (ProductID int NOT NULL AUTO_INCREMENT, ProductName varchar(255) NOT NULL,
QuantityPerUnit float(10,2), UnitPrice decimal (10,2), UnitsInStock int unsigned,
UnitsOnOrder double (10,2), Discontinued BOOLEAN, CategoryID int NOT NULL,
PRIMARY KEY (ProductID), FOREIGN KEY(CategoryID) REFERENCES categories(CategoryID));

describe categories;
describe products;




