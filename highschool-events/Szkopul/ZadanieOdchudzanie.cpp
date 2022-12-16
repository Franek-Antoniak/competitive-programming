#include <iostream>
using namespace std;

int main() {
    std::ios_base::sync_with_stdio(0);
    int n;
    int max_w = 0;
    int min_w = 2147483647;
    int last_result = 0;
    cin >> n;
    int weight;
    
    for ( int i = 0; i < n; ++i ) {
        cin >> weight;
        if ( weight < min_w ) {
            min_w = weight;
        }
        if (max_w >= min_w) {
            if (max_w - min_w > last_result) {
                last_result = max_w - min_w;    
                min_w = weight;
            }
        }
        if ( weight > max_w ) {
            max_w = weight;
            min_w = weight;
        }
    }
    
    cout << last_result;
    return 0;
}