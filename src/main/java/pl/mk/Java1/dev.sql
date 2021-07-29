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

INSERT INTO products(ProductName, UnitPrice, UnitsInStock, Discontinued, CategoryID) VALUES
('tort brzoskwiniowy', 54.5, 3, false, 1);

INSERT INTO products(ProductName, UnitPrice, UnitsInStock, Discontinued, CategoryID) VALUES
('gorąca czekolada', 12.59, 40, false, 1),
('tarta marchewkowa', 15, 1, false, 1);

INSERT INTO products(ProductName, UnitPrice, UnitsInStock, Discontinued, CategoryID) VALUES
('ciasteczka domowe', 9.99, 10, true, 1),
('ciasto drożdżowe', 15, 3, false, 1),
('baklava', 19, 0, true, 1),
('nugat z owocami', 22, 2, false, 1);

INSERT INTO products(ProductName, UnitPrice, UnitsInStock, Discontinued, CategoryID) VALUES
('ser szwajcarski dojrzewający - deska', 9.99, 6, true, 2),
('jogurt owczy', 11.5, 3, false, 2),
('gorgonzola z rodzynkami', 19, 0, true, 2),
('cheddar 3-miesięczny', 22, 2, false, 2),
('ser z rzodkiewką', 6, 6, false, 2),
('mleko świeże', 8, 6, false, 2);

INSERT INTO products(ProductName, UnitPrice, UnitsInStock, Discontinued, CategoryID) VALUES
('makaron z serem', 9.99, 3, true, 3),
('ravioli ze szpinakiem', 22.5, 3, false, 3),
('bułka paryska', 2, 0, true, 3),
('bułka sezamowa', 2.5, 2, false, 3),
('makaron domowy', 12, 9, false, 3),
('chleb z makiem', 8, 6, false, 3),
('makaron bolognese', 24, 6, false, 3),
('makaron tagliatelle z serem i warzywami', 28, 6, false, 3),
('otręby pszenne', 8.39, 6, false, 3);

INSERT INTO products(ProductName, UnitPrice, UnitsInStock, Discontinued, CategoryID) VALUES
('herbata szielona', 9.99, 3, true, 4),
('whisky podwójna', 22, 3, false, 4),
('woda mineralna', 2, 0, true, 4),
('woda niegazowana', 2.5, 2, false, 4),
('kawa podwójna', 11, 9, false, 4),
('kawa espresso', 8.5, 6, false, 4),
('cognac', 24.22, 6, false, 4),
('szampan - lampka', 29, 6, false, 4),
('herbata czarna', 7.99, 6, false, 4);

INSERT INTO products(ProductName, UnitPrice, UnitsInStock, Discontinued, CategoryID) VALUES
('sos pomidorowy', 9.79, 3, true, 5),
('sos czosnkowy z pietruszką', 7, 3, false, 5),
('majonez domowy', 4, 0, true, 5),
('ketchup', 2.5, 6, false, 5),
('sos sojowy - podwójny', 11, 11, false, 5),
('mieszanka przypraw indyjska', 8.9, 16, false, 5),
('curry oryginalne', 20.05, 10, false, 5),
('imbir marynowany', 30.00, 6, false, 5),
('sos warzywny', 7.99, 3, false, 5);

INSERT INTO products(ProductName, UnitPrice, UnitsInStock, Discontinued, CategoryID) VALUES
('jabłka krajowe', 9.79, 13, true, 6),
('gruszki', 7, 4, false, 6),
('czereśnie',5.6 , 0, true, 6),
('czereśnie - mala porcja', 2.9, 12, false, 6),
('bób', 15, 12, false, 6),
('fasola zapiekana', 18.9, 12, false, 6),
('tofu', 20.05, 22, false, 6),
('melon japoński', 41.00, 5, false, 6),
('brokół', 7.99, 21, false, 6);

INSERT INTO products(ProductName, UnitPrice, UnitsInStock, Discontinued, CategoryID) VALUES
('jabłka zagraniczne', 13.00, 99, true, 6),
('agrest czerwony', 6.12, 11, false, 6);





