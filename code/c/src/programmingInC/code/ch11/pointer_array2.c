#include <stdio.h>

int arraySum (int *array, const int n) {

	int sum = 0;
	int * const arrayEnd = array + n;

	for ( ; array < arrayEnd; array++)
		sum += *array;

	return sum;
}

int main (void) {

	int arraySum (int *array, const int n);
	int values[5] = {2, 4, 6, 8, 10};

	printf("The sum is %i\n", arraySum (values, 5));

	return 0;
}
