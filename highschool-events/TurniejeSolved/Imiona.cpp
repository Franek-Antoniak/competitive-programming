#include <iostream>

using namespace std;

int main()
{
    std::ios_base::sync_with_stdio(0); 
    string nazwiska[5] = {"Gawrychowski", "Lorys", "Nowak", "Pokorski", "Uznanski"};
    string imiona[5] = {"Pawel", "Krzysztof", "Rafal", "Karol", "Przemyslaw"};
    string x;
    cin >> x;
    int counter = 0;
    while((nazwiska[counter]) != x)
    {
       counter++;
    }
    cout << imiona[counter];
}

