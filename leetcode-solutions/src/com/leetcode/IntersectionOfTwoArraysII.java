package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class IntersectionOfTwoArraysII {
	class NonSortingSolution {
		public int[] intersect(int[] nums1, int[] nums2) {
			HashMap<Integer, Integer> map = new HashMap<>();
			IntStream.of(nums1)
			         .forEach(i -> map.put(i, map.getOrDefault(i, 0) + 1));
			int[] result = new int[nums1.length];
			int k = 0;
			for (int j : nums2) {
				if (map.containsKey(j) && map.get(j) > 0) {
					result[k++] = j;
					map.put(j, map.get(j) - 1);
				}
			}
			return IntStream.of(result).limit(k).toArray();
		}
	}
	class SortingSolution {
		public int[] intersect(int[] nums1, int[] nums2) {
			Arrays.sort(nums1);
			Arrays.sort(nums2);
			int[] result = new int[nums1.length];
			int i = 0, j = 0, k = 0;
			while (i < nums1.length && j < nums2.length) {
				if (nums1[i] == nums2[j]) {
					result[k++] = nums1[i];
					i++;
					j++;
				} else if (nums1[i] < nums2[j]) {
					i++;
				} else {
					j++;
				}
			}
			return IntStream.of(result).limit(k).toArray();
		}
	}
}