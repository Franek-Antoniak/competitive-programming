package com.leetcode;

public class StringToInteger {
	class Solution {
		public int myAtoi(String s) {
			s = s.trim();
			if (s.length() == 0) {
				return 0;
			}
			int symb = 1;
			int from = 0;
			if (s.charAt(0) == '-' || s.charAt(0) == '+') {
				symb = s.charAt(0) == '-'
				       ? -1
				       : 1;
				from = 1;
			} else if (!Character.isDigit(s.charAt(0))) {
				return 0;
			}
			long sum = 0;
			for (int i = from; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
				sum *= 10;
				sum += s.charAt(i) - '0';
				if (sum * symb > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}
				if (sum * symb < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
			}
			return (int) sum * symb;
		}
	}
}

