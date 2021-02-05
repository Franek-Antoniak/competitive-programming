#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std;

int main()
{
    std::ios_base::sync_with_stdio(0);
    cin.tie(nullptr);
    long long maxx = -1;
    long long b = -1;
    long long n;
    long long count;
    cin >> n;
    for(long long i = 1; i <= n; i++)
    {
        long long a;
        cin >> a;
        if(a > maxx)
        {
            maxx = a;
            count = i;
        }
    }
    cout << maxx << " " << count;
}