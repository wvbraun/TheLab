/* make sure theres dead pets */
SELECT name, age FROM pet WHERE dead = 1;

DELETE FROM pet WHERE dead = 1;

SELECT * FROM pet;

INSERT INTO pet VALUES (1, "Momo", "Cat", 1, 0);

SELECT * FROM pet;
