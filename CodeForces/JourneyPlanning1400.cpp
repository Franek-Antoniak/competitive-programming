#include <iostream>
#include <vector>
#include <unordered_map>

int main() {
    std::vector<long long> input;
    long long n;
    std::cin >> n;
    for( long long i = 0; i < n; i++)
    {
        long long x;
        std::cin >> x;
        input.push_back(x);
    }
    std::unordered_map<long long, std::vector<long long>> sub_sets;

    for(long long i = 0 ; i < input.size(); ++i) {
        long long value = i - input[i];
        if(sub_sets.find(i) == sub_sets.cend()) {
            sub_sets.insert(std::make_pair(value, std::vector<long long>()));
        }

        sub_sets.at(value).emplace_back(i);
    }

    long long max_val = 0;
    for (std::pair<long long, std::vector<long long>> element : sub_sets)
    {
        long long sum = 0;
        for(long long i : element.second) {
            sum += input[i];
        }
        if(sum > max_val) {
            max_val = sum;
        }
    }
    std::cout << max_val;
}