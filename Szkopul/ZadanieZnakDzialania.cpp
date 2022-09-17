#include <iostream>
#include <string>
using namespace std;
int a = 0;
int b = 0;
int c = 0;
int main()
{
    std::ios_base::sync_with_stdio(0);
    std::cin >> a >> b;
     if ((a*b == a-b) || (a*b == a+b) || (a+b == a-b))
    {
        std::cout << "NIE";
    }
    else
        {
    if (max((max((a*b),(a+b))),(a-b))==(a*b))
    {
        if((a<0) && (b<0))
        {
            if((a*b)<0)
                std::cout << "(" << a << ")*(" << b << ")=" << "(" << a*b << ")";
            else
                std::cout << "(" << a << ")*(" << b << ")=" << a*b;
        }
        else if((a<0))
        {
            if((a*b)<0)
                std::cout << "(" << a << ")*" << b << "=" << "(" << a*b << ")";
            else
                std::cout << "(" << a << ")*" << b << "=" << a*b;
        }
        else if((b<0))
        {
            if((a*b)<0)
                std::cout << a << "*(" << b << ")=" << "(" << a*b << ")";
            else
                std::cout << a << "*(" << b << ")=" << a*b;
        }
        else
        {
            if((a*b)<0)
                std::cout << a << "*" << b << "=" << "(" << a*b << ")";
            else
                std::cout << a << "*" << b << "=" << a*b;
        }
    }
    else if (max((max((a*b),(a+b))),(a-b))==(a-b))
    {
        if((a<0) && (b<0))
        {
            if((a-b)<0)
                std::cout << "(" << a << ")-(" << b << ")=" << "(" << a-b << ")";
            else
                std::cout << "(" << a << ")-(" << b << ")=" << a-b;
        }
        else if((a<0))
        {
            if((a-b)<0)
                std::cout << "(" << a << ")-" << b << "=" << "(" << a-b << ")";
            else
                std::cout << "(" << a << ")-" << b << "=" << a-b;
        }
        else if((b<0))
        {
            if((a-b)<0)
                std::cout << a << "-(" << b << ")=" << "(" << a-b << ")";
            else
                std::cout << a << "-(" << b << ")=" << a-b;
        }
        else
        {
            if((a-b)<0)
                std::cout << a << "-" << b << "=" << "(" << a-b << ")";
            else
                std::cout << a << "-" << b << "=" << a-b;
        }
    }
    else
    {
        if((a<0) && (b<0))
        {
            if((a+b)<0)
                std::cout << "(" << a << ")+(" << b << ")=" << "(" << a+b << ")";
            else
                std::cout << "(" << a << ")+(" << b << ")=" << a+b;
        }
        else if((a<0))
        {
            if((a+b)<0)
                std::cout << "(" << a << ")+" << b << "=" << "(" << a+b << ")";
            else
                std::cout << "(" << a << ")+" << b << "=" << a+b;
        }
        else if((b<0))
        {
            if((a+b)<0)
                std::cout << a << "+(" << b << ")=" << "(" << a+b << ")";
            else
                std::cout << a << "+(" << b << ")=" << a+b;
        }
        else
        {
            if((a+b)<0)
                std::cout << a << "+" << b << "=" << "(" << a+b << ")";
            else
                std::cout << a << "+" << b << "=" << a+b;
        }
    }
        }       
}