package com.leetcode;

public class DivideTwoIntegers {
	class Solution {
		public int divide(int dividend, int divisor) {
			int znak = 1;
			if (!(dividend < 0 && divisor < 0) && (dividend < 0 || divisor < 0)) {
				znak = -1;
			}
			if (dividend == Integer.MIN_VALUE) {
				if (divisor == -1) {
					return Integer.MAX_VALUE;
				}
				if (divisor == 1) {
					return Integer.MIN_VALUE;
				}
			}
			if (dividend == Integer.MAX_VALUE) {
				if (divisor == -1) {
					return Integer.MIN_VALUE + 1;
				}
				if (divisor == 1) {
					return Integer.MAX_VALUE;
				}
			}
			int[] div = new int[32];
			int result = 0;
			dividend = -Math.abs(dividend);
			divisor = Math.abs(divisor);
			div[0] = divisor;
			int counter = 0;
			for (int i = 1; i < 29; i++) {
				int temp = div[i - 1] + div[i - 1];
				if (temp > 0 && -temp > dividend) {
					div[i] = temp;
					counter = i;
				} else {
					counter = i - 1;
					break;
				}
			}
			while (dividend <= -divisor) {
				for (; counter >= 0; counter--) {
					if (dividend + div[counter] <= 0) {
						dividend += div[counter];
						result += 1 << counter;
						break;
					}
				}
			}
			if (znak == 1 && result < 0) {
				return Integer.MAX_VALUE;
			}
			return znak * result;
		}
	}
}

