CREATE TABLE person (
	id INTEGER PRIMARY KEY, 
	first_name TEXT, 
	last_name TEXT,
	age INTEGER
);

CREATE TABLE pet (
	id INTEGER PRIMARY KEY, 
	name TEXT, 
	breed TEXT, 
	age INTEGER, 
	dead INTEGER
);

CREATE TABLE person_pet ( 
	person_id INTEGER, 
	pet_id INTEGER
);

INSERT INTO person ( id, first_name, last_name, age ) 
	VALUES (0, "Brandon", "Peavler", 19);
INSERT INTO person VALUES (1, "Ted", "Smith", 22);
INSERT INTO person VALUES (2, "John", "Bravo", 40);
INSERT INTO person VALUES (3, "Rummer", "Bershtein", 19);

INSERT INTO pet (id, name, breed, age, dead)
	VALUES(0, "Momo", "Cat", 3, 1);
INSERT INTO pet VALUES (1, "Lil Bits", "Cat", 10, 0);
INSERT INTO pet VALUES (2, "Hammy", "Hamster", 1, 1);
INSERT INTO pet VALUES (3, "Giga", "Robot", 2, 1);

INSERT INTO person_pet (person_id, pet_id)
	VALUES (0, 0);
INSERT INTO person_pet VALUES (0, 1);
INSERT INTO person_pet VALUES (3, 1);
INSERT INTO person_pet VALUES (2, 3);

SELECT * FROM person; 
SELECT name, age FROM pet; 
SELECT first_name, last_name FROM person WHERE age = 19;
SELECT name, breed, age FROM pet WHERE dead = 0; 

SELECT pet.id, pet.name, pet.breed, pet.age, pet.dead 
	FROM pet, person_pet, person 
	WHERE 
	pet.id = person_pet.pet_id AND 
	person_pet.person_id = person.id AND 
	person.first_name = "Brandon";

SELECT person.id, person.first_name, person.last_name, person.age
	FROM person, person_pet, pet
	WHERE 
	person.id = person_pet.person_id AND 
	person_pet.pet_id = pet.id AND 
	pet.name = "Hammy";

SELECT name, age FROM pet WHERE dead = 1; 
DELETE FROM pet WHERE dead = 0; 
DELETE FROM pet WHERE dead = 1 AND name = "Giga";

SELECT * FROM pet; 

INSERT INTO pet VALUES (1, "Lil Bits", "Cat", 10, 0);
INSERT INTO pet VALUES (3, "Giga", "Robot", 1, 0);

ALTER TABLE person ADD COLUMN dead INTEGER; 
ALTER TABLE person ADD COLUMN phone_number TEXT;
ALTER TABLE person ADD COLUMN salary FLOAT; 
ALTER TABLE person ADD COLUMN dob DATETIME; 

ALTER TABLE pet ADD COLUMN parent TEXT; 

ALTER TABLE person_pet ADD COLUMN purchase_date DATETIME;

UPDATE person SET dead = 0, phone_number = "8122250671", salary = 100000.0, dob = 02/16/1994 WHERE id = 0;

UPDATE person SET dead = 0, phone_number = "8675309", salary = 100.0, dob = 10/11/1985 WHERE id = 1;

UPDATE person SET dead = 1, phone_number = "NONE", salary = 26000.0, dob = 12/25/1970 WHERE id = 2;

UPDATE person SET dead = 0, phone_number = "9890988", salary = 35000.0, dob = 02/12/1994 WHERE id = 3;

UPDATE pet SET parent = "Brandon" WHERE id = 0; 
UPDATE pet SET parent = "Brandon" WHERE id = 1; 
UPDATE pet SET parent = "Rummer"  WHERE id = 2; 
UPDATE pet SET parent = "John"  WHERE id = 3; 

UPDATE person_pet SET purchase_date = 03/12/2003 WHERE pet_id = 0; 
UPDATE person_pet SET purchase_date = 04/18/1999 WHERE pet_id = 1;
UPDATE person_pet SET purchase_date = 06/17/2012 WHERE pet_id = 2;
UPDATE person_pet SET purchase_date = 11/20/2004 WHERE pet_id = 3;

SELECT * FROM person;
SELECT * FROM pet;
SELECT * FROM person_pet;
