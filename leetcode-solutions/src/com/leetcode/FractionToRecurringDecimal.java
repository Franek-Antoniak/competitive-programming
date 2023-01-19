package com.leetcode;

import java.util.HashMap;

public class FractionToRecurringDecimal {
	class Solution {
		public String fractionToDecimal(int numerator, int denominator) {
			if (numerator == 0) {
				return "0";
			}
			StringBuilder result = new StringBuilder();
			result.append((numerator > 0) ^ (denominator > 0) ? "-" : "");
			long num = Math.abs((long) numerator);
			long dem = Math.abs((long) denominator);
			result.append(num / dem);
			num %= dem;
			if (num == 0) {
				return result.toString();
			}
			result.append(".");
			HashMap<Long, Integer> map = new HashMap<>();
			while (num != 0) {
				num *= 10;
				result.append(num / dem);
				num %= dem;
				if (map.containsKey(num)) {
					result.insert(map.get(num), "(");
					result.append(")");
					break;
				}
				map.put(num, result.length());
			}
			return result.toString();
		}
	}
}


