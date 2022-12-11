package com.leetcode;

public class ClimbingStairs {
    class Solution {
        public int climbStairs(int n) {
            if (n == 1)
                return 1;
            int fib1 = 1, fib2 = 2, result = 2;
            for (int i = 2; i < n; i++) {
                result = fib1 + fib2;
                fib1 = fib2;
                fib2 = result;
            }
            return result;
        }
    }
}
