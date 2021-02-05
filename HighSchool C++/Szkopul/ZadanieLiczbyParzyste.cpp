#include <iostream>
 
using namespace std;
 
int main()
{
   std::ios_base::sync_with_stdio(0);
   int d, n, wynik[1000];
   cin >> n;
   for(int i = 0; i < n; i++)
   {
       cin >> d;
       if(d % 2 == 1)
       {
           wynik[i] = 2 * d;
       }
       else wynik[i] = d;
   }
   for(int i = 0; i < n; i++)
   {
       cout << wynik[i] << " ";
   }
}