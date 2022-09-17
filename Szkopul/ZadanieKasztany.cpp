#include <iostream>
int main()
{
  std::ios_base::sync_with_stdio(0);
  long long n = 0, d = 0, a = 0, suma = 0;
  std::cin >> d;
    for (int i = 0; i<d; i++)
  {
      std::cin >> n;
      for (int k = 0; k<n; k++)
      {
          std::cin >> a;
          suma += a;
      }
      std::cout << suma << "\n";
      suma = 0;
  }
}