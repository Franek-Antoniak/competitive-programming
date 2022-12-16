#include <iostream>

using namespace std;

int main()
{
    std::ios_base::sync_with_stdio(0);
    int x,y,suma,l;
    cin >> x >> y >> l;
    suma = (x+y*2)*10;
    l = suma/l;
    l *= 10;
    cout << l;
}
