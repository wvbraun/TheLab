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

	struct Car
	{
		private string color;

		public Car(string color) 
		{
			this.color = color;
		}

		public string Describe()
		{
			return "This car is " + Color;
		}

		public string Color
		{
			get {return color;}
			set {color = value;}
		}

		/*
		 * Only classes can have destructors!
		~Car()
		{
			Console.WriteLine("Out...");
		}
		*/
	}
}
