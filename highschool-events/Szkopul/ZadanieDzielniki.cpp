#include <iostream>
#include <math.h>
using namespace std;

int loop(int iter, int intN, int sq) {
 if (iter <= sq) {
   if ( intN % iter == 0) {
     cout << iter << endl;
     int newIter = iter + 1;
     loop(newIter, intN, sq);
     int second = intN / iter;
     if (second != iter) {
       cout << second << endl;
     }
   } else {
     loop(++iter, intN, sq);
   }
 }
 return 0;
}

int foo() {
 double n;
 cin >> n;
 int sq = sqrt(double(n));
 int intN = int(n);

 loop(1, intN, sq);
 return 0;
}

int main(){
 return foo();
}