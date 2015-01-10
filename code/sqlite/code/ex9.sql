UPDATE person SET first_name = "King"
	WHERE first_name = "Brandon";
UPDATE person SET first_name = "Bitch"
	WHERE first_name = "Rummer";

UPDATE pet SET name = "The Greatest Cat Ever"
	WHERE id = 0; 
UPDATE pet SET name = "The Second Greatest Cat Ever"
	WHERE name = "Lil Bits";

SELECT * FROM person; 
SELECT * FROM pet; 

UPDATE person SET first_name = "Brandon" 
	WHERE first_name = "King";
UPDATE pet SET name = "Lil Bits" 
	WHERE name = "The Second Greatest Cat Ever";
UPDATE pet SET name = "Momo" 
	WHERE name = "The Greatest Cat Ever";

SELECT first_name FROM person WHERE last_name = "Peavler";
SELECT name FROM pet WHERE breed = "Cat";
