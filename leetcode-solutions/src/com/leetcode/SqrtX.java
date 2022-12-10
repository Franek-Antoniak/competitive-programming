package com.leetcode;

public class SqrtX {
    class Solution {
        public int mySqrt(int x) {
            int left = 1, right = x;
            int result = 0;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (mid <= x / mid) {
                    result = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return result;
        }
    }
}


