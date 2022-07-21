/**
 * Solved by Paco
 * Date: 2022-07-18 23:45:59
 * Exercise number: 412
 * Title: fizz-buzz
 * Programming Language: Java
 */

package com.paco.algorithms.java.leetcode.editor.en;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

    public static void main(String[] args) {
        Solution fb = new FizzBuzz().new Solution();
        System.out.println(fb.fizzBuzz(15));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fizzBuzz(int n) {
            List<String> res = new ArrayList();
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    res.add("FizzBuzz");
                } else if (i % 3 == 0) {
                    res.add("Fizz");
                } else if (i % 5 == 0) {
                    res.add("Buzz");
                } else {
                    res.add(Integer.toString(i));
                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}