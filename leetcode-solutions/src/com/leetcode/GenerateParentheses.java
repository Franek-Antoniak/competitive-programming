package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
	class Solution {
		List<String> solutions = new ArrayList<>();

		public List<String> generateParenthesis(int n) {
			createSolutions(0, new char[n * 2], n, n);
			return solutions;
		}

		private void createSolutions(int i, char[] chars, int l, int r) {
			if (r == 0 && l == 0) {
				solutions.add(new String(chars));
				return;
			}
			if (l != 0) {
				char[] chars1 = Arrays.copyOf(chars, chars.length);
				chars1[i] = '(';
				createSolutions(i + 1, chars1, l - 1, r);
			}
			if (r > l) {
				char[] chars2 = Arrays.copyOf(chars, chars.length);
				chars2[i] = ')';
				createSolutions(i + 1, chars2, l, r - 1);
			}
		}
	}
}

