// Program 14.1
// Program to print the number of days in a month. 

#include <stdio.h>

int main (void) {

	enum month {jan = 1, feb, mar, apr, may, jun, jul, 
			aug, sep, oct, nov, dec};

	enum month aMonth;
	int days;

	printf("Enter month number: ");
	scanf("%i", &aMonth);

	switch (aMonth) {

		case jan:
		case mar:
		case may:
		case jul:
		case aug:
		case oct:
		case dec:
			days = 31;
			break;

		case apr:
		case jun:
		case sep:
		case nov:
			days = 30;
			break;
		
		case feb:
			days = 28;
			break;

		default:
			printf ("Bad Number.\n");
			days = 0;
			break;
	}

	if (days != 0)
		printf("Number of days: %i\n", days);

	if (aMonth == feb)
		printf("...or 29 if leap year.\n");

	return 0;
}
