#include<iostream>

using namespace std;

int main()
{
    std::ios_base::sync_with_stdio(0);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n, tym;
    cin >> n;
    int tab[1010] = {}; // robo wygrywa
    int wynik1 = 0, wynik2 = 0;
    for(int i = 0; i < n; i++)
    {
        cin >> tym;
        tab[i] = tym;
    }
    for(int i = 0; i < n; i++)
    {
        cin >> tym;
        if(tym != tab[i])
        {
            if(tym > tab[i]) wynik2++;
            else if(tab[i] > tym) wynik1++;
        }
    }
    if(wynik1 == 0 && wynik2 == 0)
    {
        cout << -1;
        return 0;
    }
    else if(wynik2 > wynik1 && wynik1 == 0) cout << -1;
    else if(wynik1 > wynik2) cout << 1;
    else
    {
        for(int i = 1; i <= 1010; i++)
        {
            if((wynik1 * i) > wynik2)
            {
                cout << i;
                return 0;
            }
        }
    }
}
