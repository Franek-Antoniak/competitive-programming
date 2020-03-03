#include<iostream>

using namespace std;

int main()
{
    std::ios_base::sync_with_stdio(0);
    cin.tie(nullptr);
    cout.tie(nullptr);
    double O, D;
    long long T, P;
    cin >> D >> O >> P >> T;
    O = D/O;
    T = T*O;
    P = T/P;
    cout << P;
}
