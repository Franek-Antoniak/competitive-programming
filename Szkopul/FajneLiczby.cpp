#include "bits/stdc++.h"
#define gc getchar_unlocked

using namespace std;

inline void wpisz(int &x)
{
    x = 0;
    long long mnoz = 1;
    register char c = gc();
    if(c == '-')
    {
        mnoz = -1;
        c = gc();
    }
    for(;c<48||c>57;c=gc());
    for(;c>47&&c<58;c=gc())
        x = ((x<<3) + (x<<1) + c-48);
    x *= mnoz;
}

/*void update(int* tree, int leaf_index, int value, bool node = false) {
    if (leaf_index < 1) return;
    if(node)
    {
        tree[leaf_index] = tree[leaf_index * 2] + tree[leaf_index * 2 + 1];
    }
    else
    {
        tree[leaf_index] = value;
    }
    update(tree, leaf_index/2, value, true);
}*/

void update(int* tree, int leaf_index, int value)
{
    if(tree[leaf_index] != value)
    {
        tree[leaf_index] = value;
        if(value == 0) value = -1;
        leaf_index /= 2;
        while(leaf_index > 0)
        {
            tree[leaf_index] += value;
            leaf_index /= 2;
        }
    }
}


int query(int v, int L, int R , int a, int b, int* tree) //'v' jest numerem węzła w drzewie
{
    if (L == a && R == b) {
        return tree[v];
    }

    int mid = (a + b) / 2;
    if (R <= mid) {
        return query(2 * v, L, R, a, mid, tree);
    } else if (L > mid) {
        return query(2 * v + 1, L, R, mid + 1, b, tree);
    } else {
        return query(2 * v, L, mid, a, mid, tree) + query(2 * v + 1, mid + 1, R, mid + 1, b, tree);
    }
}

int main()
{
    std::ios_base::sync_with_stdio(0);
    int q, k, x, v, L, R, n, value, operation;
    wpisz(n);
    wpisz(q);
    wpisz(k);
    const int LEAF_COUNT = pow(2,ceil(log2(n))); // ile lisci
    const int TREE_SIZE = 2 * LEAF_COUNT; // ile nodeow w drzewie
    int* tree = new int[TREE_SIZE]; // robimy drzewo
    for(int i = 0; i < TREE_SIZE; i++)
    {
        tree[i] = 0;
    }
    for(int i = 0; i < n; i++) // tutaj wbijamy nasze pierwsze liczby
    {
        wpisz(x); // tu x uzywamy do wartosci
        if(x <= k) value = 0;
        else value = 1;
        update(tree, i + LEAF_COUNT, value);
    }

    for(int i = 0; i < q; i++) // operacje
    {
        wpisz(operation);
        if(operation == 0)
        {
            wpisz(x);
            wpisz(v);
            v = v <= k ? 0 : 1;
            x += (LEAF_COUNT-1);
            update(tree, x, v);
        }
        else
        {
            wpisz(L);
            wpisz(R);
            cout << query(1, L, R, 1, LEAF_COUNT, tree) << "\n";
        }
    }
}