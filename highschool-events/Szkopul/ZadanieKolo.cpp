#include <iostream>
#include <math.h>
#include <iomanip>
#define M_PI 3.14159265358979323846
int main()
{
  double r = 0;
  std::cin >> r;
  std::cout.precision(3);
  std::cout << std::fixed;
  std::cout  << (r*r*M_PI) << std::endl;
  std::cout  << (r*2*M_PI) << std::endl;
}