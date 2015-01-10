
#include <stdio.h>
#include <assert.h> // assert header is used for debugging. 
#include <stdlib.h> // defines 4 variable types, several macros, and
//various functions. 
#include <string.h> // provides function useful for manipulating strings. 


// creates structure w 4 elements. 
struct Person { 
	char *name;
	int age;
	int height;
	int weight;
};


//allows us to create Person structures 
struct Person *Person_create(char *name, int age, int height, int weight) {
	// malloc for memory allocate to ask the OS to give piece of raw memory 
	// malloc(sizeof() calculuate the total size of the struct, given the fields inside. 
	// assert make sures i have valid peice of memory back from malloc. 
	// assert makes sure malloc did not return a NULL invalid pointer. 
	struct Person *who = malloc(sizeof(struct Person));
	assert(who != NULL);

	// initalize each field of struct using x->y syntax. 
	who->name = strdup(name); // use strdup() to duplicate the
       //					string for the name.
	who->age = age;
	who->height = height;
	who->weight = weight;

	return who;
}


void Person_destroy(struct Person *who) {

	// asert make sure not getting bad input. 
	assert(who->name);

	// free returns the memory i got w malloc and strdup,
	// so i dont get a memory leak. 
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
	struct Person *joe = Person_create("Joe Alex", 32, 64, 140);

	struct Person *frank = Person_create(
			"Frank Blank", 20, 72, 180);

	// print them out where they are in memory
	// use %p to show where the program has put 
	// the struct in memory. 
	printf("Joe is at memory location %p:\n", joe);
	Person_print(joe);

	printf("Frank is at memory location: %p:\n", frank);
	Person_print(frank);

	// make everyone age 20 years and print them again
	joe->age += 20;
	joe->height += 2;
	joe->weight += 40;
	Person_print(joe);

	frank->age += 20;
	frank->weight += 20;
	Person_print(frank);

	//destroy them both so we can clean up
//	Person_destroy(joe);
//	Person_destroy(frank);

	return 0;

}
