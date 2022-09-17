#include <iostream>

int main()
{
	int t = 0, g = 0, m = 0, s = 0, suma = 0;
	std::cin >> t;
	g = t / 3600;
	m = (t % 3600) / 60;
	s = t - (60 * (60 * g + m));
	std::cout
		<< g << "g"
		<< m << "m"
		<< s << "s";
}