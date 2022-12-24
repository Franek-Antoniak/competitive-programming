package com.leetcode;

public class MissingNumber {
	class Solution {
		public int missingNumber(int[] nums) {
			int xor = 0;
			int i = 0;
			for (; i < nums.length; i++) {
				xor ^= nums[i] ^ i;
			}
			return xor ^ i;
		}
	}

}
