using System;
using System.Collections;

namespace AbstractClasses
{
	class Program
	{
		static void Main()
		{
			Dog dog = new Dog();
			Dog1 dog1 = new Dog1();
			Console.WriteLine(dog.Describe());
			Console.WriteLine(dog1.Describe());
		}
	}

	abstract class FourLeggedAnimal
	{
		public virtual string Describe()
		{
			return "Not much is known about this four legged animal!";
		}
	}

	class Dog : FourLeggedAnimal
	{
		public override string Describe()
		{
			return "This four legged animal is a Dog!";
		}
	}
	
	class Dog1 : FourLeggedAnimal
	{
		public override string Describe()
		{
			string res = base.Describe();
			res += " ...In fact, it is a dog!";
			return res;
		}
	}
}

