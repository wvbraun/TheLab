#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <string.h>

struct Person {
	char *name;
	int age;
	int heigt; 
	int weight;
};

struct Person *Person_create(char *name, int age, int height, int weight) { 

	struct Person *who = malloc(sizeof(struct Person)); 
	assert(who != NULL);

	who->name = strdup(name);
	who->age = age;
	who->height = height;
	who->weight = weight; 

	return who;
}

void Person_destroy(struct Person *who) {

	assert(who != NULL);

	free(who->name);
	free(who);
}

void Person_print(struct Person *who) {

	printf("Name: %s\n", who->name);
	printf("\tAge: %d\n", who->age);
	printf("\tHeight: %d\n", who->height);
	printf("\tWeight: %d\n", who->weight);
}

int main(int argc, char *argv[]) {

	// make two people structures 
	struct Person *joe = Person_create(
			"Joe Alex", 32, 64, 140);

	struct Person *john = Person_create(
			"Johny Bravo", 28, 72, 210);

	printf("Joe is at mem location %p:\n", joe);
	Person_print(joe);

	printf("John is at mem location %p:\n", john);
	Person_print(john);

	Person_destroy(joe);
	Person_destroy(john);

	return 0;
}
