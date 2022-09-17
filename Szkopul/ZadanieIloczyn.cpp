#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int bob[50] = {};
    bob[0] = 0;
    bob[1] = 1;
    for(int i = 2; i < 45; i++)
    {
        bob[i] = bob[i-1] + bob[i-2];
    }
    int n, t;
    cin >> t;
    int coco = 0;
    for(int i = 0; i < t; i++)
    {
        cin >> n;
        for(int a = 44; a > 1; a--)
        {
            if(coco == 2) break;
            if (n % bob[a] == 0)
            {
                n /= bob[a];
                coco++;
                if(n == 1 || n == 0) break;
                a = 45;
            }
        }
        if(n == 1 || n == 0) cout << "TAK\n";
        else cout << "NIE\n";
        coco = 0;
    }
}