#include<iostream>
using namespace std;
 
int main()
{
    std::ios_base::sync_with_stdio(0);
    int n = 0;
    int sum = 0;
    int k = 0;
    int counters[10] = {0};
   
    cin >> n >> k;
   
    for (int i = 0; i < n; ++i) {
        int number;
        cin >> number;
        counters[number] += 1;
    }
   
    int current_index = 0;
    while (k > 0 && current_index < 10) {
        if (counters[current_index] >= k) {
            counters[current_index] -= k;
            counters[9] += k;
            k = 0;
        } else {
            counters[9] += counters[current_index];
            k -= counters[current_index];
            counters[current_index] = 0;
        }
        current_index++;
    }
   
    for (int i = 0; i < 10; ++i) {
        sum += counters[i] * i;
    }
   
    cout << sum;
   
}