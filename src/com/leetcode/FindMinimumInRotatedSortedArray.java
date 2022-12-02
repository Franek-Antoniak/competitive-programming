package com.leetcode;

public class FindMinimumInRotatedSortedArray {
	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray.Solution s = new FindMinimumInRotatedSortedArray().new Solution();
		System.out.println(s.findMin(new int[]{5, 1, 2, 3, 4}));
		System.out.println(s.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
		System.out.println(s.findMin(new int[]{3, 4, 5, 1, 2}));
		System.out.println(s.findMin(new int[]{1, 2, 3, 4, 5}));
		System.out.println(s.findMin(new int[]{2, 1}));
		System.out.println(s.findMin(new int[]{1}));
		System.out.println(s.findMin(new int[]{1, 2}));
		System.out.println(s.findMin(new int[]{2, 1, 3}));
		System.out.println(s.findMin(new int[]{3, 1, 2}));
		System.out.println(s.findMin(new int[]{1, 3, 2}));
		System.out.println(s.findMin(new int[]{15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
	}

	class Solution {
		public int findMin(int[] nums) {
			int start = 0, end = nums.length - 1;
			int result = 0;
			while (start <= end) {
				result = (start + end) / 2;
				if (nums[result] < nums[end]) {
					end = result;
				} else if (nums[result] < nums[start]) {
					start = result;
				} else if (nums[start] > nums[end]) {
					start = result + 1;
				} else {
					end = result - 1;
				}
			}
			return nums[result];
		}
	}
}
