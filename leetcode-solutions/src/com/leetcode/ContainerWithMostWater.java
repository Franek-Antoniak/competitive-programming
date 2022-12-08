package com.leetcode;


public class ContainerWithMostWater {
	class Solution {
		public int maxArea(int[] height) {
			// Initialize left and right pointers
			int left = 0;
			int right = height.length - 1;

			// Initialize maximum area seen so far
			int max = 0;

			// Iterate until left pointer passes right pointer
			while (left < right) {
				// Calculate width of container
				int w = right - left;
				// Calculate height of container (min of left and right heights)
				int h = Math.min(height[left], height[right]);
				// Calculate area of container
				int area = h * w;
				// Update maximum area seen so far if necessary
				max = Math.max(max, area);

				// Move left or right pointer depending on which line is shorter
				if (height[left] < height[right]) {
					left++;
				} else if (height[left] > height[right]) {
					right--;
				}
				// If heights are equal, move both pointers
				else {
					left++;
					right--;
				}
			}
			// Return maximum area seen
			return max;
		}
	}
}