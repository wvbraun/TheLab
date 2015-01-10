class die 
{
	public int sides = 6;
	public int value; 
}


class wtf
{
	public static void Main()
	{
		die Die1 = new die();
		die Die2 = new die();
	
	
		Die1.sides = 6; 
		Die2.sides = 6; 
		Die1.value = 10;
		Die2.value = 5; 
	
	
		System.Console.WriteLine("Die 1 has {0} sides and a value of {1}", Die1.sides, Die1.value);
		System.Console.WriteLine("Die 2 has {0} sides and a vlue of {1}", Die2.sides, Die2.value);
	}
}
