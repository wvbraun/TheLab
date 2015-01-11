// Define a type functionPtr (using typedef) that represents
// a pointerto a function that returns an int and takes
// no arguments. 

#include <stdio.h>

typedef int (*functionPtr) (void);

//---------------------------------------------------------
// Write a function called monthName that takes as its argument a 
// value of atype enum month and returns a pointer to a character
// string containg the name of the month. 
// printf("%s\n", monthName (aMonth));

enum month {'Jan'=1, 'Feb', 'Mar', Apr', 'Jun', 'Jul', 'Aug', 'Oct',
	'Nov', 'Dec',};


