package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	class Solution {
		public List<List<Integer>> subsets(int[] nums) {
			List<List<Integer>> result = new ArrayList<>();
			result.add(new ArrayList<>());
			for (int num : nums) {
				int size = result.size();
				for (int j = 0; j < size; j++) {
					List<Integer> list = new ArrayList<>(result.get(j));
					list.add(num);
					result.add(list);
				}
			}
			return result;
		}
	}
}
