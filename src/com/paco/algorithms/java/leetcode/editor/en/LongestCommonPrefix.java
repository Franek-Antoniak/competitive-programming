/**
 * Solved by Paco
 * Date: 2022-07-24 17:28:47
 * Exercise number: 14
 * Title: longest-common-prefix
 * Programming Language: Java
 */

package com.paco.algorithms.java.leetcode.editor.en;

public class LongestCommonPrefix {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String ans = strs[0];
            for (String s : strs) {
                if (ans == "")
                    break;
                while (!(s.startsWith(ans)))
                    ans = ans.substring(0, ans.length() - 1);
            }
            return ans;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}