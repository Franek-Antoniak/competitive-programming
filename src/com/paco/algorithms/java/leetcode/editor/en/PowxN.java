/**
 * Solved by Paco
 * Date: 2022-07-22 12:12:09
 * Exercise number: 50
 * Title: powx-n
 * Programming Language: Java
 */

package com.paco.algorithms.java.leetcode.editor.en;

public class PowxN {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (x == 1)
                return 1;
            if (n < 0)
                return 1 / (fastPow(x, -n));
            return fastPow(x, n);
        }

        public double fastPow(double x, int n) {
            if (n == 0)
                return 1;
            double result = fastPow(x, n / 2);
            if (n % 2 == 0)
                return result * result;
            return result * result * x;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}