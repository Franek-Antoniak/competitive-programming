#include <iostream>

using namespace std;

int main()
{
    std::ios_base::sync_with_stdio(0);
    string n;
    cin >> n;
    for(int i = 0; i < n.length(); i++)
    {
        if(n[i] == 'a' )n[i] = '4';
        if(n[i] == 'e' )n[i] = '3';
        if(n[i] == 'i') n[i] = '1';
        if(n[i] == 'o' ) n[i] = '0';       
        if(n[i] == 's' )n[i] = '5';        
    }
    cout << n;
}