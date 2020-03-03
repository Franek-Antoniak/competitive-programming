#include <iostream>
#include <cmath>

using namespace std;

int main() {
    std::ios_base::sync_with_stdio(0);
    unsigned long long n, counter = 0;
    cin >> n;
    if(n == 2)
    {
        cout << 2;
        return 0;
    }
    if(n == 1)
    {
        cout << 1;
        return 0;
    }
    if(n == 3)
    {
        cout << 3;
        return 0;
    }
    if(n % 2 == 0)
    {
        cout << 3;
        return 0;
    }
    else
    {
        cout << 4;
        return 0;
    }
}