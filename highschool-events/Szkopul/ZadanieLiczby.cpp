#include <iostream>
#include <algorithm>

int main()
{
int n = 0, tab[1000000], tab2[1000000], k = 0, a = 81247;
std::cin >> n;
std::cin >> k;
for (int i = 0; i < n; i++)
    {
        std::cin >> tab[i];
    }
std::sort(tab, tab + n);
for (int q = 0; q < k; q++)
    {
        tab2[q] = tab[q];
    }
for (int p = 0; p < k; p++)
    {
        if (tab2[p] == a) continue;
        else std::cout << tab2[p] << "\n";
        a = tab2[p];
    }
}