#include <iostream>
 
using namespace std;
 
int main()
{
   std::ios_base::sync_with_stdio(0);
   int d, n, wynik;
   cin >> n;
   for(int i = 0; i < n; i++)
   {
       cin >> d;
       switch(d)
       {
           case 6:
           {
               wynik++;
               break;
           }
           default: break;
       }
   }
   cout << wynik;
}