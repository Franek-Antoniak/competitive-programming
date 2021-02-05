#include <iostream>
 
using namespace std;
 
int main()
{
std::ios_base::sync_with_stdio(0);
    int n = 0;
    cin >> n;
    int val;
    bool tab[1000001] = {};
    for (int i = 0; i < n; ++i) {
        cin >> val;
        if (val > n || val <= 0 || tab[val - 1]) {
            std::cout << "NIE";
            return 0;
        } else {
            tab[val - 1] = true;
        }
    }
    std::cout << "TAK";
    return 0;
}