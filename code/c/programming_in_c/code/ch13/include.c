// program to illustrate the use of the #include statement 
// with metric.h

#include <stdio.h>
#include "metric.h"

int main (void) {

	float liters, gallons;

	printf ("*** Liters to Gallons ***\n\n");
	printf ("Enter the number of liters: ");
	scanf ("%f", &liters);

	gallons = liters * Q_PER_L / 4.0;
	printf ("%g liters = %g gallons\n", liters, gallons);

	return 0;
}
