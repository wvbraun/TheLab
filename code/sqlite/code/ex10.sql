SELECT * FROM pet; 

UPDATE pet SET name = "Brandon's Dead Pet" WHERE id IN (
	SELECT pet.id
	FROM pet, person, person_pet 
	WHERE 
	person.id = person_pet.person_id AND 
	pet.id = person_pet.pet_id AND 
	person.first_name = "Brandon" AND 
	pet.dead = 1
);

SELECT * FROM pet; 

