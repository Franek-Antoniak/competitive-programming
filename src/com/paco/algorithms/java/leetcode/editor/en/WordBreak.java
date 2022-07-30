/**
 * Solved by Paco
 * Date: 2022-07-24 19:51:08
 * Exercise number: 139
 * Title: word-break
 * Programming Language: Java
 */

package com.paco.algorithms.java.leetcode.editor.en;

import java.util.*;

public class WordBreak {

    // Main method
    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        String s = "catsandog";
        List<String> dict = List.of("cat", "cats", "and", "sand", "dog");
        boolean result = wb.new Solution().wordBreak(s, dict);
        System.out.println(result);
    }


    /**
     * Solution 1:
     * Recursive Solution with Memoization
     * Time Complexity:
     * Average Case: O(n^2),  The Worst Case: O(n^3) with the HashSet
     * Space Complexity: O(n)
     * The Worst Case & Average Case with TreeSet: O(n^2 * log(n))  with the HashSet
     */
    public class RecursiveSolution {
        public boolean wordBreak(String s, List<String> wordDict) {
            return wordBreakMemo(s, new TreeSet<>(wordDict), 0, new Boolean[s.length()]);
        }

        private boolean wordBreakMemo(String s, Set<String> wordDict, int start, Boolean[] memo) {
            if (start == s.length()) {
                return true;
            }
            if (memo[start] != null) {
                return memo[start];
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDict.contains(s.substring(start, end)) && wordBreakMemo(s, wordDict, end, memo)) {
                    return memo[start] = true;
                }
            }
            return memo[start] = false;
        }
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet = new HashSet<>(wordDict);
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[s.length()];
            queue.add(0);
            while (!queue.isEmpty()) {
                int start = queue.remove();
                if (visited[start]) {
                    continue;
                }
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = true;
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
