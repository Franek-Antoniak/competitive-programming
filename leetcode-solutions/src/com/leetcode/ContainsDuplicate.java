package com.leetcode;

import java.util.Arrays;

public class ContainsDuplicate {
	class Solution {
		public boolean containsDuplicate(int[] nums) {
			return (Arrays.stream(nums).distinct().count() - nums.length) != 0;
		}
	}
}


