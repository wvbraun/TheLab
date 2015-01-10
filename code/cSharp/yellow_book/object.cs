using System;

class Account {
	public string Name;
};

class blah {
	public static void Main() {
		Account bp;
		bp = new Account();
		bp.Name = "Brandon";
		Console.WriteLine(bp.Name);
	}
}
