using System;

public class Animal
{
	public virtual void Greet()
	{
		Console.WriteLine("Hello, I am an animal!");
	}
}

public class Dog : Animal 
{
	public override void Greet()
	{
		Console.WriteLine("Hello, I am a dog!");
	}
}
