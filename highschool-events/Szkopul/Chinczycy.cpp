#include <iostream>
#include <cmath>


using namespace std;



long long query(long long v, long long L, long long R , long long a, long long b, long long n, long long* tree)
{
    long long k;
    if (L == a && R == b) {
        k = log2(n) - log2(b - a + 1); // jeden                                 
        long long x = pow(2, k) + ((a * pow(2, k)) / n);
        if(a == b) x--; // zrobilismy tu u gory wzor jak przelozyc przedzial    
        return tree[x];
    }

    long long mid = (a + b - 1) / 2;
    if (R <= mid) {
        return query(2 * v, L, R, a, mid, n, tree);
    } else if (L > mid) {
        return query(2 * v + 1, L, R, mid + 1, b, n, tree);
    } else {
        return query(2 * v, L, mid, a, mid, n, tree) + query(2 * v + 1, mid + 1,
                                                             R, mid + 1, b, n, tree);
    }
}


void update(long long* tree, long long leaf_index, long long value, bool node = false)
{
    if (leaf_index < 1) return;
    if(node)
    {
        tree[leaf_index] = tree[leaf_index * 2] + tree[leaf_index * 2 + 1];
    }
    else
    {
        tree[leaf_index] += value;
    }
    update(tree, leaf_index/2, value, true);
}

int main()
{
    std::ios_base::sync_with_stdio(0);
    long long n, q, k, a, b, c, operacja;
    cin >> n >> q;
    const long long LEAF_COUNT = pow(2,ceil(log2(n)));
    const long long TREE_SIZE = 2 * LEAF_COUNT;
    const long long TREE_HEIGHT = log2(TREE_SIZE);

    long long* tree = new long long[TREE_SIZE];
    for(long long i = 0; i < TREE_SIZE; i++)
    {
        tree[i] = 0;
    }
    for(long long i = 0; i < q; i++) // operacje                                      
    {
        cin >> operacja;
        if(operacja == 1)
        {
            cin >> a >> b ; // tu x uzywamy jako indeks v jako wartoc           
            a += (LEAF_COUNT-1);
            update(tree, a, b);
        }
        else
        {
            cin >> a >> b;
            cout << query(1, a, b, 1, LEAF_COUNT, LEAF_COUNT, tree) << "\n";
        }
    }

}