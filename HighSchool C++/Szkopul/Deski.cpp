#include <iostream>
#include <algorithm>
#include <functional>
#include <math.h>

using namespace std;

int main()
{
    std::ios_base::sync_with_stdio(0); 
    int n;
    cin >> n;
    if(n < 4)
    {
        cout << 0;
        return 0;
    }
    long long x;
    long long * tab = new long long[n];
    for(int i = 0; i < n; i++)
    {
        cin >> x;
        tab[i] = x;
    }
    sort(tab, tab + n, greater < long long >());
    
    cout << tab[3]*tab[3];
}