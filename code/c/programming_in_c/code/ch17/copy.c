// program to copy one file to another using command line.

#include <stdio.h>

int main (int argc, char *argv[]) {

	FILE *in, *out;
	int c;

	if (argc != 3) {
		fprintf(stderr, "Need two files names\n");
		return 1;
	}

	if ( (in = fopen (argv[1], "r")) == NULL) {

		fprintf(stderr, "Cannot read %s.\n", argv[1]);
		return 2;
	}

	if ( (out = fopen(argv[2], "w")) == NULL) {
		fprintf(stderr, "cannot write %s. \n", argv[2]);
		return 3;
	}

	while ( (c = getc (in)) != EOF) 
		putc (c, out);

	printf("FIle has been copied.\n");

	fclose(in);
	fclose(out);

	return 0;
}
