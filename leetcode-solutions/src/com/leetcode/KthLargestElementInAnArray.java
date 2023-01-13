package com.leetcode;

public class KthLargestElementInAnArray {
	class Solution {
		public int findKthLargest(int[] nums, int k) {
			return quickSelect(0, nums.length - 1, nums, k);
		}

		private int quickSelect(int start, int end, int[] nums, int k) {
			int random = (int)(Math.random() * (end - start)) + start;
			swap(random, end, nums);
			int pivot = nums[end], freePos = start;
			for (int i = start; i <= end; i++) {
				if (nums[i] < pivot) {
					swap(i, freePos++, nums);
				}
			}
			swap(end, freePos, nums);
			int result = end - freePos + 1;
			if (result == k)
				return pivot;
			if (result > k) {
				return quickSelect(freePos + 1, end, nums, k);
			}
			return quickSelect(start, freePos - 1, nums, k - result);
		}

		private void swap(int x, int y, int[] nums) {
			int temp = nums[x];
			nums[x] = nums[y];
			nums[y] = temp;
		}
	}
}

