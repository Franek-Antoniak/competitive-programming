package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	class Solution {
		public List<List<Integer>> generate(int numRows) {
			List<List<Integer>> list = new ArrayList<>();
			List<Integer> last = List.of(1);
			list.add(last);
			for (int i = 1; i < numRows; i++) {
				ArrayList<Integer> next = new ArrayList<>();
				for (int j = 0; j <= i; j++) {
					if (j == 0 || j == i) {
						next.add(1);
					} else {
						next.add(last.get(j - 1) + last.get(j));
					}
				}
				last = next;
				list.add(next);
			}
			return list;
		}
	}
}

