#include "bits/stdc++.h"

using namespace std;

int  main()
{
    std::ios_base::sync_with_stdio(false);
    int n, a;
    char x;
    string war;
    cin >> n;
    int flaga;
    bool tab2[30] = {};
    int tab[30] = {};
    for(int i = 0; i < n; i++)
    {
        cin >> x;
        cin >> war;
        if(war[0] == '+')
        {
            war[0] = '0';
            a = atoi(war.c_str());
            flaga = int(x-65);
            tab[flaga] += a;
            tab2[flaga] = true;
        }
        else
        {
            war[0] = '0';
            a = atoi(war.c_str());
            flaga = int(x-65);
            tab[flaga] -= a;
            tab2[flaga] = true;
        }
    }
    for(int i = 0; i < 26; i++)
    {
        if(tab2[i]) cout << char(i+65) << " " << tab[i] << "\n";
    }
}