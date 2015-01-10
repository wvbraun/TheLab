/* this should fail bc 0 is taken */
INSERT INTO person (id, first_name, last_name, age)
	VALUES (0, 'Frank', 'Smith', 100);

/* but we can force it w INSERT OR REPLACE */
INSERT OR REPLACE INTO person VALUES (0, 'Frank', 'Smith', 100);

SELECT * FROM person;

/* shorthand for this is simply replace */

REPLACE INTO person VALUES (0, "Brandon", "Peavler", 19);

SELECT first_name, last_name FROM person WHERE id = 0;
