package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TopKFrequentElements {
	class Solution {
		public int[] topKFrequent(int[] nums, int k) {
			HashMap<Integer, Integer> map = new HashMap<>();
			int max = Integer.MIN_VALUE;
			for (int i : nums) {
				map.compute(i, (a, b) -> b == null ? 1 : b + 1);
			}
			List<Integer>[] bucket = new List[nums.length + 1];
			for (int i : map.keySet()) {
				int freq = map.get(i);
				if (bucket[freq] == null) {
					bucket[freq] = new ArrayList<>();
				}
				bucket[freq].add(i);
				max = Math.max(max, freq);
			}
			int[] result = new int[k];
			for (int i = max; i > 0; i--) {
				if (bucket[i] != null) {
					for (int j : bucket[i]) {
						if (k > 0) {
							result[--k] = j;
						} else {
							return result;
						}
					}
				}
			}
			return result;
		}
	}
}


