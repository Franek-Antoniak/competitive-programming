#include <iostream>
using namespace std;

int main()
{
    std::ios_base::sync_with_stdio(0);
    int x, y, z, v;
    cin >> x >> y >> z >> v;
    if((x + y == z + v) || (x == y && z == v))
    {
        cout << "TAK";
        return 0;
    }
    cout << "NIE";
}
    
