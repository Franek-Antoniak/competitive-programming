package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	class Solution {
		List<Integer> res = new ArrayList<>();

		public List<Integer> spiralOrder(int[][] matrix) {
			spiral(matrix, matrix.length, matrix[0].length, 0);
			return res;
		}

		private void spiral(int[][] matrix, int n, int m, int c) {
			if (c == (n + 1) / 2 || c == (m + 1) / 2) {
				return;
			}
			for (int j = c; j < m - c; j++) {
				res.add(matrix[c][j]);
			}
			for (int j = c + 1; j < n - c; j++) {
				res.add(matrix[j][m - c - 1]);
			}
			if (n - c - 1 != c) {
				for (int j = m - c - 2; j >= c; j--) {
					res.add(matrix[n - c - 1][j]);
				}
			}
			if (m - c - 1 != c) {
				for (int j = n - c - 2; j > c; j--) {
					res.add(matrix[j][c]);
				}
			}
			spiral(matrix, n, m, c + 1);
		}
	}

}


