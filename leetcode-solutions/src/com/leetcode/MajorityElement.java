package com.leetcode;

public class MajorityElement {
	class Solution {
		public int majorityElement(int[] nums) {
			int x = nums[0];
			int y = 1;
			for (int i = 1; i < nums.length; i++) {
				if (nums[i] != x) {
					if (--y == 0) {
						y = 1;
						x = nums[i];
					}
				} else {
					y++;
				}
			}
			return x;
		}
	}
}

