// program to copy one file to another

#include <stdio.h>

int main (void) {

	char inName[64], outName[64];
	FILE *in, *out;
	int c;

	// get file names from user
	
	printf("Enter name of file to be copied: ");
	scanf("%63s", inName);
	printf("Enter name of output file: ");
	scanf("%63s", outName);

	// open input and output files
	
	if ( (in = fopen (inName, "r")) == NULL) {
		printf("Cannot open %s for reading.\n", inName);
		return 1;
	}

	if ( (out = fopen (outName, "w")) == NULL) {
		printf("Cannot open %s for writing.\n", outName);
		return 1;
	}

	// copy in to out
	while ( (c = getc (in)) != EOF)
		putc (c, out);

	// close open file 
	
	fclose(in);
	fclose(out);

	printf("File has been copied.\n");

	return 0;
}
