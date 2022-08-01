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

    /**
     * Solution 1:
     * Recursive Solution with Memoization
     * Time Complexity:
     * Average Case: O(n^3),  The Worst Case: O(n^4) with the HashSet
     * Space Complexity: O(n)
     * The Worst Case & Average Case with TreeSet: O(n^3 * log(n)
     */
    public class RecursiveSolution {
        public boolean wordBreak(String s, List<String> wordDict) {
            return wordBreakMemo(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
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

    /**
     * Solution 2:
     * BFS Solution
     * Time Complexity:
     * O(n^3 * log(n))
     * Space Complexity: O(n)
     */
    public class BFSSolution {
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

    // Solution 3:
    // DP Solution
    // Time Complexity: O(n^3)
    // Space Complexity: O(n)
    // The Worst Case: O(n^4) with the HashSet
    // The Worst Case with TreeSet: O(n^3 * log(n))
    public class DPSolution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }

    // Solution 4:
    // DP Solution
    // Time Complexity: O(n^2 * wordDict.size())
    // Space Complexity: O(n)
    // Nice trick with the for each loop in the wordDict instead of using double for loop to iterate over the every
    // substring of the string.
    // Leetcode runtime: 3ms faster than 93.39% of Java submissions
    public class ListDPSolution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] t = new boolean[s.length() + 1];
            t[0] = true;
            for (int i = 0; i < s.length(); i++) {
                if (!t[i]) continue;
                for (String a : wordDict) {
                    int len = a.length();
                    int end = i + len;
                    if (end > s.length()) continue;
                    if (t[end]) continue;
                    if (s.substring(i, end)
                            .equals(a)) {
                        t[end] = true;
                    }
                }
            }
            return t[s.length()];
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    
    //leetcode submit region end(Prohibit modification and deletion)

}
