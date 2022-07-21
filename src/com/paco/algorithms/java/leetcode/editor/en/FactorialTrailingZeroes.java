/**
 * Solved by Paco
 * Date: 2022-07-21 23:44:14
 * Exercise number: 172
 * Title: factorial-trailing-zeroes
 * Programming Language: Java
 */

package com.paco.algorithms.java.leetcode.editor.en;

public class FactorialTrailingZeroes {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trailingZeroes(int n) {
            if (n < 5)
                return 0;
            int counter = 0;
            while (n > 0) {
                n /= 5;
                counter += n;
            }
            return counter;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}