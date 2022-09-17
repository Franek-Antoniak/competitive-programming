#include <iostream>
using namespace std;
 
int main() {
    std::ios_base::sync_with_stdio(0);
    int n = 0;
    int sum = 0;
    cin >> n;
    int a = 0;
    
    for (int i = 1; i <= n; ++i) {
        cin >> a;
        sum += a;
    }
    cout << min(sum, n-sum);
}