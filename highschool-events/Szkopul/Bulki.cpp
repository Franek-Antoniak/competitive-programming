#include <iostream>
 
int main()
{
  int input = 0;
  int lg = 1;
  int i = 0;
  std::cin >> input;
  while (input > lg) {
      lg = lg*2;
      i++;
  }
  std::cout << i;
  return 0;   
}