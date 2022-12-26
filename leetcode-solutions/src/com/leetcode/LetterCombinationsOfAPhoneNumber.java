package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	class Solution {
		private static char[][] map;
		private List<String> solution = new ArrayList<>();

		public List<String> letterCombinations(String digits) {
			map = new char[][]{{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
					{'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
			createCombination(0, new StringBuilder(), digits);
			if (solution.get(0).equals("")) {
				solution.remove(0);
			}
			return solution;
		}

		private void createCombination(int i, StringBuilder s, String digits) {
			if (s.length() == digits.length()) {
				solution.add(s.toString());
				return;
			}
			for (int q = 0; q < map[digits.charAt(i) - '0'].length; q++) {
				createCombination(i + 1, new StringBuilder(s).append(map[digits.charAt(i) - '0'][q]), digits);
			}

		}
	}
}

