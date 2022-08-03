/**
 * Solved by Paco
 * Date: 2022-07-24 19:52:09
 * Exercise number: 187
 * Title: repeated-dna-sequences
 * Programming Language: Java
 */


package com.paco.algorithms.java.leetcode.editor.en;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RepeatedDnaSequences {
    // Solution 1
    // Time complexity: O(n^2) because of use of substring()
    // Space complexity: O(n) because of use of HashMap
    // Pretty slow, but it works
    // Brute force solution
    static class BrutForceSolution {
        public List<String> findRepeatedDnaSequences(String s) {
            if (s.length() < 10) {
                return List.of();
            }
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length() - 9; i++) {
                String sub = s.substring(i, i + 10);
                if (map.containsKey(sub)) {
                    map.put(sub, map.get(sub) + 1);
                } else {
                    map.put(sub, 1);
                }
            }
            return map.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() > 1)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
    }

    // Solution 2
    static class Solution {
        public List<String> findRepeatedDnaSequences(String s) {
            return List.of();
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    //leetcode submit region end(Prohibit modification and deletion)
}
