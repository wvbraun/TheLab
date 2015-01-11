// ex 16 - structs and Pointers 

#include <stdio.h>
#include <assert.h>
#include <stdlib.h>
#include <string.h>

struct Person {
	char *name;
	int age;
	int height;
	int weight;
};

struct Weed {
	char *strain;
	int price;
	float weight;
};

// creates a pointer called *Person_create of type struct Person
struct Person *Person_create(char *name, int age, int height, int weight) { 

	// creates a pointer *who of type struct Person
	struct Person *who = malloc(sizeof(struct Person));
	assert( who != NULL);

	who->name = strdup(name);
	who->age = age;
	who->height = height;
	who->weight=weight;

	return who;
}

struct Weed *Weed_create(char *strain, int price, float weight) {

	struct Weed *wut = malloc(sizeof(struct Weed));
	assert(wut != NULL);

	wut->strain = strdup(strain);
	wut->price = price;
	wut->weight = weight;

	return wut;
}

// functin with arguments *who
void Person_destroy(struct Person *who) {

	assert(who != NULL);

	free(who->name);
	free(who);
}

void Weed_destroy(struct Weed *wut) {

	assert (wut != NULL);
	free(wut->strain);
	free(wut);
}

void Person_print(struct Person *who) {

	printf("Name: %s\n", who->name);
	printf("\tAge: %d\n", who->age);
	printf("\tHeight: %d\n", who->height);
	printf("\tWeight: %d\n", who->weight);
}

void Weed_print(struct Weed *wut) {

	printf("Strain: %s\n", wut->strain);
	printf("\tPrice: %d\n", wut->price);
	printf("\tWeight: %f\n", wut->weight);
}

int main (int argc, char *argv[]) {

	struct Person *brandon = Person_create(
			"Brandon Peavler", 19, 67, 160);

	struct Person *cally = Person_create(
			"Cally Carroll", 20, 64, 110);

	struct Weed *sativa = Weed_create(
			"AK-47", 45, 3.5);
	struct Weed *indica = Weed_create(
			"OG Kush", 40, 3.5);

	printf("Brandon is at memory location %p: \n", brandon);
	Person_print(brandon);

	printf("Cally is at memory location %p: \n", cally);
	Person_print(cally);

	printf("AK-47 is at mem location %p: \n", sativa);
	Weed_print(sativa);

	printf("OG Kush is at mem location %p: \n", indica);
	Weed_print(indica);

	brandon->age += 20;
	brandon->height +=5;
	brandon->weight +=30;
	Person_print(brandon);


	Person_destroy(brandon);
	Person_destroy(cally);
	
	Weed_destroy(sativa);
	Weed_destroy(indica);
	
	return 0;
}
