/* only drop table if it exist */
DROP TABLE IF EXISTS person; 

CREATE TABLE person (
	id INTEGER PRIMARY KEY, 
	first_name TEXT, 
	last_name TEXT, 
	age INTEGER 
);

/* rename table to peoples */
ALTER TABLE person RENAME TO peoples;

/*add a hatred column to peoples */
ALTER TABLE peoples ADD COLUMN hatred INTEGER;

/*rename peoples back to person */
ALTER TABLE peoples RENAME TO person; 

.schema person 

DROP TABLE person; 

