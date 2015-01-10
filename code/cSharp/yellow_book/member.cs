using System;

class blah {
	static int member = 0;

	static void OtherMethod() {
		member = 99;
	}

	static void Main() {
		Console.WriteLine("member is: " + member);
		OtherMethod();
		Console.WriteLine("member is: " + member);
	}
}
