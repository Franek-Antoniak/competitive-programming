#include <iostream>
using namespace std;

int main() 
{
   int odleglosc, odlKozik, odlAdr;
   bool teraz = false; //1 - ruch Kozika, 0 - Adriana
   cin >> odleglosc >> odlKozik >> odlAdr;
   int n;
   n = odleglosc / (odlKozik + odlAdr); // ile krokow bedzie
   odleglosc = odleglosc - (odlKozik + odlAdr) * (n - 1); 
   // odleglosc - (jeden krok * ile krokow) 
   // odlgeglosc pod koniec operacji jest rowna
   // albo 0 albo pozostala reszta gdy odleglosc
   // przez sume krokow Kozika i Adriana
   // ma resztę

   while (odleglosc >= 0) 
   {
      teraz = !teraz;
      if (teraz) odleglosc = odleglosc - odlKozik;
      if (!teraz) odleglosc = odleglosc - odlAdr;
   }

   cout << teraz;
}