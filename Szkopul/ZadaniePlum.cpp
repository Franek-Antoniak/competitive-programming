#include <iostream>

int main()
{
int a = 0, b = 0, d = 0, c = 0;;
std::cin >> a;
std::cin >> b;
c = (b-a);
for(int i = 0; i <= c; i++)
{
  if ((a+d)%7 == 0) std::cout << "plum\n";
      else
      {
          if ((a+d)%10 == 7) std::cout << "plum\n";
          else if(((((a+d)%100)-(((a+d)%10)))/10) == 7) std::cout << "plum\n";
          else if((a+d)/100 == 7) std::cout << "plum\n";
          else std::cout << (a+d) << "\n";
      }
d += 1;
}
}