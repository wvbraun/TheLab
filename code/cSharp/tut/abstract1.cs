using System;
using System.Collections;

class Program
{
	static void Main()
	{
		ArrayList animalList = new ArrayList();
		animalList.Add(new Dog());
		animalList.Add(new Cat());

		foreach (FourLeggedAnimal animal in animalList)
			Console.WriteLine(animal.Describe());

	}
}

abstract class FourLeggedAnimal
{
	public abstract string Describe();
}

class Dog : FourLeggedAnimal
{
	public override string Describe()
	{
		return "I am a dog!";
	}
}

class Cat : FourLeggedAnimal
{
	public override string Describe()
	{
		return "I am a cat!";
	}
}
