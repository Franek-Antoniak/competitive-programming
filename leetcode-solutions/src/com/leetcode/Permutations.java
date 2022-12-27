package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	class Solution {
		ArrayList<List<Integer>> result = new ArrayList<>();
		public List<List<Integer>> permute(int[] nums) {
			permute(nums, 0);
			return result;
		}

		private void permute(int[] nums, int i) {
			if (i == nums.length) {
				ArrayList<Integer> list = new ArrayList<>();
				for (int num : nums) {
					list.add(num);
				}
				result.add(list);
				return;
			}
			int value = nums[i];
			for (int q = i; q < nums.length; q++) {
				nums[i] = nums[q];
				nums[q] = value;
				permute(nums, i + 1);
				nums[q] = nums[i];
				nums[i] = value;
			}
		}
	}
}


