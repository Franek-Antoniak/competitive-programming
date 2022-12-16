#include <iostream>

using namespace std;

int main()
{
    std::ios_base::sync_with_stdio(0);
    string c;
    int n, lewa = 0, prawa = 0;
    cin >> n;
    cin >> c;
    for(int i = 0; i < n; i++)//lewa
    {
        if(c[i] == '<') lewa++;
        else break;
    }
    for(int i = n-1; i >= 0; i--)
    {
        if(c[i] == '>') prawa++;
        else break;
    }
    cout << prawa+lewa;
}