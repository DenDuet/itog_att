## 1. Создаем базу данных humansFriendsdb
DROP DATABASE IF EXISTS humansFriendsdb;
CREATE DATABASE humansFriendsdb;
USE humansFriendsdb;

## 2. Создаем таблицы животных
DROP TABLE IF EXISTS cat;
CREATE TABLE cat (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);

DROP TABLE IF EXISTS dog;
CREATE TABLE dog (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);

DROP TABLE IF EXISTS hamster;
CREATE TABLE hamster (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);

DROP TABLE IF EXISTS horse;
CREATE TABLE horse (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);

DROP TABLE IF EXISTS camel;
CREATE TABLE camel (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);

DROP TABLE IF EXISTS donkey;
CREATE TABLE donkey (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);
  
## 3. Заполняем данными таблицы животных
INSERT INTO cat (Name, Command, Birthday) values
    ('Кис-кисыч', 'Играть', '2022-11-01'),
	('Пушистик', 'Играть', '2022-10-04'),
    ('Мурка', 'Играть', '2019-11-15');
SELECT * FROM cat;

INSERT INTO dog (Name, Command, Birthday) values
    ('Шарик', 'Бежать', '2022-05-11'),
	('Тузик', 'Бежать', '2021-08-04'),
    ('Лайма', 'Бежать', '2020-10-17');
SELECT * FROM dog;
 
INSERT INTO hamster (Name, Command, Birthday) values
    ('Хома', 'Бежать', '2021-11-11'),
    ('Пушок', 'Бежать', '2017-12-06'),
    ('Пушистик', 'Бежать', '2019-03-17');
SELECT * FROM hamster;
     
INSERT INTO camel (Name, Command, Birthday) values
    ('Агата', 'Идти', '2021-11-01'),
	('Ланцелот', 'Идти', '2020-02-16'),
    ('Джаред', 'Идти', '2021-06-11');
SELECT * FROM camel;
     
INSERT INTO horse (Name, Command, Birthday) values
    ('Мерин', 'Рысь', '2019-04-01'),
    ('Буран', 'Рысь', '2017-01-06'),
    ('Осман', 'Рысь', '2020-11-17');
SELECT * FROM horse;    
     
INSERT INTO donkey (Name, Command, Birthday) values
    ('Алдар', 'Идти', '2020-11-01'),
    ('Бригелла', 'Идти', '2017-12-06'),
    ('Моисей', 'Идти', '2019-11-17');
SELECT * FROM donkey; 

## ________________________________________________________________________ 
## 4. Удаляем данные из таблицы верблюдов
DELETE FROM camel WHERE id > 0;
SELECT * FROM camel;

## ________________________________________________________________________ 
## 5. Объединяем таблицы лошадей и ослов в одну таблицу.
DROP TABLE IF EXISTS otherAnimals;
CREATE TABLE otherAnimals (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);

INSERT INTO otherAnimals (Name, Command, Birthday)
SELECT  Name, 
        Command, 
        Birthday
FROM horse UNION 
SELECT  Name, 
        Command, 
        Birthday
FROM donkey;
SELECT * FROM otherAnimals;

## Создаем таблицу домашних животных
DROP TABLE IF EXISTS homeAnimals;
CREATE TABLE homeAnimals (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);
INSERT INTO homeAnimals (Name, Command, Birthday)
SELECT  Name, 
        Command, 
        Birthday
FROM cat UNION 
SELECT  Name, 
        Command, 
        Birthday
FROM dog UNION 
SELECT  Name, 
        Command, 
        Birthday
FROM hamster;
SELECT * FROM homeAnimals;

## _________________________________________________________________________
## 6. Создаем таблицу, в которой все животные в возрасте от 1 до 3 лет.
DROP TABLE IF EXISTS YoungAnimals;
CREATE TABLE YoungAnimals (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE,
    `Age, month` INT
);

INSERT INTO YoungAnimals (Name, Command, Birthday, `Age, month`)
SELECT  Name, 
        Command, 
        Birthday,
        ((YEAR(CURRENT_DATE)-YEAR(Birthday))*12+(MONTH(CURRENT_DATE)-MONTH(Birthday))
        ) AS `age, month`
FROM homeAnimals WHERE ((YEAR(CURRENT_DATE)-YEAR(Birthday))*12+(MONTH(CURRENT_DATE)-MONTH(Birthday))) < 36 AND 
	((YEAR(CURRENT_DATE)-YEAR(Birthday))*12+(MONTH(CURRENT_DATE)-MONTH(Birthday))) > 12
UNION ALL
SELECT  Name, 
        Command, 
        Birthday,
        ((YEAR(CURRENT_DATE)-YEAR(Birthday))*12+(MONTH(CURRENT_DATE)-MONTH(Birthday))
        ) AS `age,  month`
FROM otherAnimals WHERE ((YEAR(CURRENT_DATE)-YEAR(Birthday))*12+(MONTH(CURRENT_DATE)-MONTH(Birthday))) < 36 AND 
	((YEAR(CURRENT_DATE)-YEAR(Birthday))*12+(MONTH(CURRENT_DATE)-MONTH(Birthday))) > 12;

SELECT * FROM YoungAnimals;

## __________________________________________________________________________________________
## 7. Объединяем все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.
DROP TABLE IF EXISTS HumanFriend;
CREATE TABLE HumanFriend (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
SELECT  Name, 
        Command,
        Birthday,
        'cat' AS oldTable
FROM cat UNION 
SELECT  Name, 
        Command, 
        Birthday,
        'dog' AS oldTable
FROM dog UNION
SELECT  Name, 
        Command, 
        Birthday,
        'hamster' as oldTable
FROM hamster UNION 
SELECT  Name, 
        Command, 
        Birthday,
        'horse' AS oldTable
FROM horse UNION 
SELECT  Name, 
        Command, 
        Birthday,
        'donkey' AS oldTable
FROM donkey;

SELECT * FROM HumanFriend;

