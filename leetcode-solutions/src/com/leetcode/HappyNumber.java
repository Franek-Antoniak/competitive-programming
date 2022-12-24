package com.leetcode;

public class HappyNumber {
	class Solution {
		public boolean isHappy(int n) {
			int fast = n;
			while (true) {
				fast = calculate(calculate(fast));
				n = calculate(n);
				if (fast == 1 || n == 1) {
					return true;
				}

				if (n == fast) {
					return false;
				}
			}
		}

		public int calculate(int n) {
			int sum = 0;
			while (n > 0) {
				int temp2 = n % 10;
				sum += temp2 * temp2;
				n /= 10;
			}
			return sum;
		}
	}
}

