// function to sum the elements of an integer array

#include <stdio.h>

int arraySum (int array[], const int n) {

	int sum = 0, *ptr;
	int * const arrayEnd = array + n;

	for (ptr = array; ptr < arrayEnd; ptr++)
		sum += *ptr;

	return sum;
}

int main (void) {

	int arraySum (int array[], const int n);
	int values[10] = { 3, 7, -9, 3, 6, -1, 7, 9, 1, -5 };
	int wut[5] = {2, 4, 6, 8, 10};

	printf("The sum is %i\n", arraySum (values, 10));
	printf("%i\n", arraySum (wut, 5));

	return 0;
}
