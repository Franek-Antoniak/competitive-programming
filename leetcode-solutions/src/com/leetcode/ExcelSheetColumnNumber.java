package com.leetcode;

public class ExcelSheetColumnNumber {
	class Solution {
		public int titleToNumber(String columnTitle) {
			int counter = 0;
			for (int i = 0; i < columnTitle.length(); i++) {
				counter *= 26;
				counter += 1 + columnTitle.charAt(i) - 'A';
			}
			return counter;
		}
	}
}

