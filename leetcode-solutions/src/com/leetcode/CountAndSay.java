package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CountAndSay {
	class Solution {
		public String countAndSay(int n) {
			List<Integer> list = new ArrayList<>();
			list.add(1);
			for (int i = 1; i < n; i++) {
				List<Integer> temp = new ArrayList<>();
				int counter = 0, number = -1;
				int q = 0;
				while (q < list.size()) {
					counter = 0;
					number = list.get(q);
					while (q < list.size() && list.get(q) == number) {
						counter++;
						q++;
					}
					temp.add(counter);
					temp.add(number);
				}
				list = temp;
			}
			return list.stream()
			           .map(String::valueOf)
			           .reduce((a, b) -> a + b)
			           .get();
		}
	}
}

