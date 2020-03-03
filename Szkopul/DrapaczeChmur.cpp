#include "bits/stdc++.h"

using namespace std;

int  main() {
    std::ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n, k, x, mnoz = 1, wynik = 0, *tab, roznica;
    cin >> n >> k;
    tab = new int[n];
    for(int i = 0; i < n; i++) // wpisujemy liczby
    {
        cin >> x;
        tab[i] = x;
    }
    sort(tab, tab + n); // sortujemy
    wynik += tab[0];
    for(int i = 0; i < n; i++)
    {
        if(k == 0) break;
        if(i+1 == n)
        {
            wynik += k/n;
            break;
        }
        roznica = tab[i+1] - tab[i]; // roznica nastepnych wyrazow
        roznica = roznica*mnoz;
        if(roznica < k)
        {
            k -= roznica;
            wynik += roznica/mnoz;
        }
        else if(roznica >= k)
        {
            wynik += k/mnoz;
            break;
        }
        mnoz++;
    }
    cout << wynik;
}