#include <iostream>
#include <math.h>
using namespace std;

int interval_tree [4000000];
bool base_intervals [4000000];

int insert(int target, int intrvl_beg, int intrvl_end, int target_beg, int target_end, int c) {
  if (target_beg <= intrvl_beg && target_end >= intrvl_end) {
    interval_tree[target] = c;
    base_intervals[target] = true;
    return 0; 
  }
  if (intrvl_beg > target_end || intrvl_end < target_beg) {
      return 0;
  }
  if (base_intervals[target]) {
    interval_tree[target*2] = interval_tree[target*2+1] = interval_tree[target];
    base_intervals[target*2] = base_intervals[target*2+1] = true;
    base_intervals[target] = false;
  }
  int mid = (intrvl_beg + intrvl_end)/2;
  insert(2*target, intrvl_beg, mid, target_beg, target_end, c);
  insert(2*target+1, mid+1, intrvl_end, target_beg, target_end, c);
  interval_tree[target] = max(interval_tree[2*target], interval_tree[2*target+1]);
  return 0;
}

int query (int target, int intrvl_beg, int intrvl_end, int target_beg, int target_end) {
  if (target_beg <= intrvl_beg && target_end >= intrvl_end) return interval_tree[target];
  if (intrvl_beg > target_end || intrvl_end < target_beg) return -1;
  if (base_intervals[target]) return interval_tree[target];
  int mid = (intrvl_beg + intrvl_end) / 2;
  return max(
      query(2*target,intrvl_beg,mid,target_beg,target_end),
      query(2*target+1, mid+1, intrvl_end,target_beg,target_end)
  );
}

int main() {
    std::ios_base::sync_with_stdio(0);
    int d,n,l,x;
    cin >> d >> n;
    
    int width = log2(d) + 1;
    int t_SIZE = 2 << (width - 1);
    
    base_intervals[1] = true;
    
    for (int i = 0; i < n; ++i) {
        cin >> l >> x;
        int max = query(1, 1, t_SIZE, x+1, x+l);
        insert(1, 1, t_SIZE, x+1, x+l, max+1);
    }

    cout << query(1, 1, t_SIZE, 1, t_SIZE);
    return 0;   
}