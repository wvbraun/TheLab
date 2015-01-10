using System;

namespace Cars
{
	class Wut
	{
		static void Main()
		{
			Car car = new Car("Red");
			Console.WriteLine(car.Describe());

			car = new Car("Green");
			Console.WriteLine(car.Describe());

		}
	}

	class Car
	{
		// this is a field
		private string color;

		// constructor
		public Car()
		{
			Console.WriteLine("Constructor with no paramaters called first!");
		}

		// another constructor
		public Car(string color) : this()
		{
			this.color = color;
			Console.WriteLine("Constructor with color paramter called next!");
		}

		// method
		public string Describe()
		{
			return "This car is " + Color;
		}

		public string Color
		{
			get {return color;}
			set {color = value;}
		}

		~Car()
		{
			Console.WriteLine("Out...");
		}
	}
}
