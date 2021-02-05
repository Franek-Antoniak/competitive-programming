#include <iostream>
#define gc getchar_unlocked
#define pc putchar_unlocked

using namespace std;

inline void wpisz(int &x) 
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


int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n = 1;
    wpisz(n);
    int *w, *west, *east;
    w = new int [n+1];
    west = new int [n+1];
    east = new int [n+1];
    west[0] = -1;
    east[n] = -1;
    west[0] = 0;
    for(int i = 1; i < n+1; i++)
    {
        wpisz(w[i]);
        if(w[i] > west[i-1]) west[i] = w[i];
        else west[i] = west[i-1];
    }
    for(int x = n; x >= 1; x--)
    {
        if(w[x] > east[x]) east[x-1] = w[x];
        else east[x-1] = east[x];
    }
    for(int i = 1; i < n+1; i++)
    {
        cout << west[i] << " " << east[i-1] << "\n";
    }
}