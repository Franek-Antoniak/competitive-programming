#include <iostream>

using namespace std;

int main()
{
    std::ios_base::sync_with_stdio(0);
    int n, m, x;
    long long max;
    cin >> n >> m;
    int suma = 0;
    int * tab = new int[n];
    for(int i = 0; i < n; i++)
    {
        cin >> x;
        tab[i] = x;
    }

    for(int i = 0; i < m; i++)
    {
        suma += tab[i];
    }
    max = suma;
    for(int i = 0; i < n-m; i++)
    {
        suma -= tab[i];
        suma += tab[m+i];
        if(suma > max) max = suma;
    }

    cout << max;
}