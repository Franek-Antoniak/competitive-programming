package com.leetcode;

public class SearchInRotatedSortedArray {

	class Solution {
		public int search(int[] nums, int target) {
			int rot = rotation(nums);
			int left = 0, right = nums.length - 1;
			while (left < right) {
				int mid = left + (right - left) / 2;
				if (nums[(mid + rot) % nums.length] < target) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			return nums[(left + rot) % nums.length] == target
			       ? (left + rot) % nums.length
			       : -1;
		}

		public int rotation(int[] nums) {
			int left = 0, right = nums.length - 1;
			while (left < right) {
				int mid = left + (right - left) / 2;
				if (nums[mid] < nums[right]) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}
			return left;
		}
	}
}