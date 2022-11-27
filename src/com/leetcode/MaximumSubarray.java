package com.leetcode;

public class MaximumSubarray {
	class Solution {
		public int maxSubArray(int[] nums) {
			int maxSum = Integer.MIN_VALUE;
			int pomMax = 0;
			for (int num : nums) {
				if (pomMax + num < 0) {
					pomMax = 0;
					maxSum = Math.max(maxSum, num);
				} else {
					pomMax += num;
					maxSum = Math.max(maxSum, pomMax);
				}
			}
			return maxSum;
		}
	}
}