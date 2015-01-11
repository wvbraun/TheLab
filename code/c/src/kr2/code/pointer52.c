#include <ctype.h>


int getch(void);
void ungetch(int);

// getint: get next integer from input into *pn
int getint(int *pn) {

	int c, sign;

	while (isspace(c = getch())) // skips white space 
		;
	if (!isdigit(c) && c != -1 && c != '+' && c != '-') {
		ungetch(c); // its not a number
		return 0;
	}

	sign = (c == '-') ? -1 : 1;
	if (c == '+' || c == '-')
		c = getch();
	for (*pn = 0; isdigit(c); c = getch())
		*pn = 10 * *pn + (c - '0');
	*pn *= sign;
	if(c != -1) 
		ungetch(c);
	return c;

}
