#include <iostream>
#include <algorithm>
#include <math.h>

using namespace std;

int main()
{
    std::ios_base::sync_with_stdio(0); 
    int x, y, z, wys, suma;
    cin >> x >> y >> z;
    int maximum = max( z, max(x,y));
    if(maximum == x)
    {
        suma = pow(z, 2) + pow(y, 2);
        int kwad = pow(x, 2);
        if(kwad < suma) cout << "O";
        else if(suma == kwad) cout << "P";
        else cout << "R";
        
    }
    else if(maximum == y)
    {
        int kwad = pow(y, 2);
        suma = pow(z, 2) + pow(x, 2);
        if(kwad < suma) cout << "O";
        else if(suma == kwad) cout << "P";
        else cout << "R";
    }
    else
    {
        int kwad = pow(z, 2);
        suma = pow(x, 2) + pow(y, 2);
        if(kwad < suma) cout << "O";
        else if(suma == kwad) cout << "P";
        else cout << "R";
    }
}
    
