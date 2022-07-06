/**
 * Solved by Paco
 * Date: 2022-07-05 20:05:59
 * Exercise number: 567
 * Title: permutation-in-string
 */

package com.paco.algorithms.java.leetcode.editor.en;

public class PermutationInString {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int[] countArr = new int[255];
            s1.chars()
                    .forEach(ch -> countArr[ch]++);
            if (s1.length() > s2.length())
                return false;
            // Sliding Window
            int start = 0, toAchieve = s1.length(), tempAchieved = 0;
            for (int i = 0; i < s2.length(); i++) {
                if (tempAchieved == 0)
                    start = i;
                if (countArr[s2.charAt(i)] >= 1) {
                    tempAchieved++;
                    countArr[s2.charAt(i)]--;
                    if (tempAchieved == toAchieve)
                        return true;
                } else {
                    if (start == i)
                        start++;
                    for (; start < i; start++) {
                        countArr[s2.charAt(start)]++;
                        if (countArr[s2.charAt(i)] == 1) {
                            start++;
                            countArr[s2.charAt(i)]--;
                            break;
                        }
                        tempAchieved--;
                    }
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}