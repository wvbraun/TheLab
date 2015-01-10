#include <iostream>
#include <string>

int main() {

	std::cout << "Input: ";
	std::string wut;
	std::cin >> wut;

	std::string message = "Your message: " + wut;

	std::string spaces(message.size(), ' ');
	std::string second = "* " + spaces + " *";
	std::string first(second.size(), '*');


	std::cout << first << std::endl;
	std::cout << second << std::endl;
	std::cout << "* " << message << " *" << std::endl;
	std::cout << second << std::endl;
	std::cout << first << std::endl;

	return 0;
}
