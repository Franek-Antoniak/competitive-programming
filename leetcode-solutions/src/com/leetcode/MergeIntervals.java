package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
	class Solution {
		List<int[]> result = new ArrayList<>();

		public int[][] merge(int[][] intervals) {
			Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
			int[] tempInterval = intervals[0];
			for (int[] interval : intervals) {
				int[] tempNewInterval = interval(tempInterval, interval);
				if (tempNewInterval[0] == Integer.MIN_VALUE) {
					result.add(tempInterval);
					tempInterval = interval;
				} else {
					tempInterval = tempNewInterval;
				}
			}
			if (tempInterval[0] != Integer.MIN_VALUE) {
				result.add(tempInterval);
			}
			return result.toArray(int[][]::new);
		}

		private int[] interval(int[] interval1, int[] interval2) {
			if (interval1[1] >= interval2[0]) {
				return new int[]{Math.min(interval1[0], interval2[0]), Math.max(interval1[1], interval2[1])};
			}
			return new int[]{Integer.MIN_VALUE, 0};
		}
	}
}


