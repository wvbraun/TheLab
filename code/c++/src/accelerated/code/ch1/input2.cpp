// ask for persons name, generate framed greeting.
#include <iostream>
#include <string>

int main () {

	std::cout << "Enter name: ";
	std::string name;
	std::cin >> name;

	// build message we wanna write.
	const std::string greeting = "Hello, " + name + "!";

	// spaces contains as many spaces as the number of chars
	// in greeting. 
	const std::string spaces(greeting.size(), ' ');
	const std::string second = "* " + spaces + " *";

	// first contains the size of second, with all *. 
	const std::string first(second.size(), '*');

	std::cout << std::endl;
	std::cout << first << std::endl;
	std::cout << second << std::endl;
	std::cout << "* " << greeting << " *" << std::endl;
	std::cout << second << std::endl;
	std::cout << first << std::endl;

	return 0;
}

