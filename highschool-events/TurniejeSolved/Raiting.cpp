#include<iostream>

using namespace std;

int main()
{
    std::ios_base::sync_with_stdio(0);
    cin.tie(nullptr);
    cout.tie(nullptr);
    int n, sizer = 1, p = 0, *tab, maximum = 1, begin = 0;
    cin>>n;
    tab = new int[n];
    cin>>tab[0];
    for(int i=1;i<n;i++)
    {
        cin>>tab[i];
        if(tab[i]>tab[i-1])
        {
            ++sizer;
            maximum = max(sizer, maximum);
            begin = p;
        }
        else
        {
            p = i;
            sizer = 1;
        }
    }
    cout << maximum;
}
