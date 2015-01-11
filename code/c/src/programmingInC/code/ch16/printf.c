// illustrate various printf formats

#include <stdio.h>

int main (void) {

	char c = 'X';
	char s[]= "abcdefghijklmnopqrstuvwxyz";
	int i = 425;
	short int j = 17;
	unsigned int u = 0xf179U;
	long int l = 75000L;
	long long int L = 0x1234567812345678LL;
	float f = 12.978F;
	double d = -97.4583;
	char *cp = &c;
	int *ip = &i;
	int c1,c2;

	printf("Integers:\n")
	printf("%i %o %x %u\n", i, i, i, i);
	printf("%x %X %#x %#X\n", i, i, i, i);
	printf
