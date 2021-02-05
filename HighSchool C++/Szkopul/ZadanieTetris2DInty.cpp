#include <iostream>
using namespace std;

int main()
{
    std::ios_base::sync_with_stdio(0);
    int n,d;
    cin >> d >> n;
    int* ls = new int [n];
    int* xs = new int [n];
    
    for (int i = 0; i < n; ++i) {
        cin >> ls[i] >> xs[i];
    }
    
    int* lowest_poists = new int[d];
    for (int i = 0; i < d; ++i) {
        lowest_poists[i] = 0;
    }
    
    for (int i = 0; i < n; ++i) {
        int l = ls[i];
        int x = xs[i];
        int max_h = 0;
        for (int j = x; j < x+l; ++j) {
            max_h = max(max_h, lowest_poists[j]);
        }
        for (int j = x; j < x+l; ++j) {
            lowest_poists[j] = max_h+1;
        }
    }
    
    int max_h = 0;
    for (int i = 0; i < d; ++i) {
        max_h = max(max_h, lowest_poists[i]);
    }
    
    cout << max_h;
    return 0;
}