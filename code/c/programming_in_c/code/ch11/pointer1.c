// program to illustrate pointers 

#include <stdio.h>

int main (void) {

	int count = 10, x;
	int *int_pointer; // creates a pointer named int_pointer

	// the address operator & is applied to count
	// this creates a pointer to count 
	// which is assigned to int_pointer
	int_pointer = &count;
	x = *int_pointer;

	printf("count = %i, x = %i\n", count, x);

	return 0;
}
