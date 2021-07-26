CREATE DATABASE devExpress CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE TABLE categories (CategoryID int NOT NULL AUTO_INCREMENT, CategoryName varchar(255) NOT NULL,
CategoryDescription varchar(255),PRIMARY KEY (CategoryID));

CREATE TABLE products (ProductID int NOT NULL AUTO_INCREMENT, ProductName varchar(255) NOT NULL,
QuantityPerUnit float(10,2), UnitPrice decimal (10,2), UnitsInStock int unsigned,
UnitsOnOrder double (10,2), Discontinued BOOLEAN, CategoryID int NOT NULL,
PRIMARY KEY (ProductID), FOREIGN KEY(CategoryID) REFERENCES categories(CategoryID));

describe categories;
describe products;

INSERT INTO categories(CategoryName, CategoryDescription) VALUES ('Confections', 'Desserts, candies and sweet breads');
INSERT INTO categories(CategoryName, CategoryDescription) VALUES ('Dairy Products', 'Cheeses');
INSERT INTO categories(CategoryName, CategoryDescription) VALUES ('Grains', 'Breads, Crackers, Pasta');
INSERT INTO categories(CategoryName, CategoryDescription) VALUES ('Beverages', 'Softdrinks, coffees, teas, beers');
INSERT INTO categories(CategoryName, CategoryDescription) VALUES ('Condiments', 'Sweet and Savory Sauces');
INSERT INTO categories(CategoryName, CategoryDescription) VALUES ('Produce', 'Dried fruit and bean curd');



