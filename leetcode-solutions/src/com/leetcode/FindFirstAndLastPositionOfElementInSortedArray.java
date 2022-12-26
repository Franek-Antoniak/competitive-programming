package com.leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray {
	class Solution {
		public int[] searchRange(int[] nums, int target) {
			if (nums.length == 0) {
				return new int[]{-1, -1};
			}
			int left = 0, right = nums.length - 1;
			int left1 = 0, right1 = nums.length - 1;
			while (left < right) {
				int mid = (left + right) / 2;
				if (nums[mid] < target) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			while (left1 < right1) {
				int mid = (left1 + right1) / 2;
				if (nums[mid] <= target) {
					left1 = mid + 1;
				} else {
					right1 = mid;
				}
			}
			left1 = nums[left1] == target ? left1 : left1 - 1;
			if (nums[left] == target && nums[left1] == target) {
				return new int[]{left, left1};
			}
			return new int[]{-1, -1};
		}
	}
}

