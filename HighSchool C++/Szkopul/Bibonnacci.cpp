#include "bits/stdc++.h"
#define gc getchar_unlocked

using namespace std;

inline void wpisz(long long &x)
{
    x = 0;
    long long mnoz = 1;
    register char c = gc();
    if(c == '-')
    {
        mnoz = -1;
        c = gc();
    }
    for(;c<48||c>57;c=gc());
    for(;c>47&&c<58;c=gc())
        x = ((x<<3) + (x<<1) + c-48);
    x *= mnoz;
}

int  main() {
    std::ios_base::sync_with_stdio(false);
    long long n, q, m, suma = 0;
    wpisz(q);
    wpisz(m);
    long long* tab = new long long[1000010];
    tab[0] = 0 % m;
    tab[1] = 2 % m;
    tab[2] = 2 % m;
    for(long long i = 3; i <= 1000000; i++)
    {
        for(unsigned int d = 0; d <= 20; d++)
        {
            suma = i - (1 << d);
            if(suma <= 0) break;
            tab[i] += tab[suma];
        }
        tab[i] = tab[i] % m;
    }
    for(long long i = 0; i < q; i++)
    {
        wpisz(n);
        if(n <= 0) cout << 0 << "\n";
        else cout << tab[n] << "\n";
    }
}