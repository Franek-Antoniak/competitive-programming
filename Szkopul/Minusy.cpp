#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    std::ios_base::sync_with_stdio(0);
    string c;
    cin >> c;
    long long maxi = 0, aktualny = 0;
    int plusy = 0, minusy = 0;
    int n = c.length();
    for(int i = 0; i < n; i++)
    {
        if(c[i] == '+')
        {
            plusy++;
            if(i == n-1)
            {
                aktualny += plusy;
                maxi = max(maxi, aktualny);
            }
        }
        else // jasiek to bobas co jesli minus
        {
            minusy++;
            if( (c[i+1] == '+') || (i == (n-1)) )
            {
                if(minusy % 2 == 0) // jezeli parzyste
                {
                    aktualny += (minusy/2);
                    aktualny += plusy;
                    maxi = max(maxi, aktualny);
                    minusy = 0;
                    plusy = 0;
                }
                else // jezeli nieparzyste
                {
                    aktualny += (minusy/2);
                    aktualny += plusy;
                    maxi = max(maxi, aktualny);
                    i -= (minusy-1);
                    minusy = 0;
                    plusy = 0;
                    aktualny = 0;
                }
            }
        }
    }
    cout << maxi;
}