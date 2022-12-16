#include <iostream>

int main()
{
    int max = -2147483648;
    int min = 2147483647;
    int tmp;
    for (int i = 0; i < 10; ++i) {   
        std::cin >> tmp;
        if (tmp > max) {
            max = tmp;
        }
        if (tmp < min) {
            min = tmp;
        }
    }
    
    std::cout << min << "\n" << max;
}