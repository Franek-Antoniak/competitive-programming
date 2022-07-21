/**
 * Solved by Paco
 * Date: 2022-07-01 18:59:09
 * Exercise number: 557
 * Title: reverse-words-in-a-string-iii
 * Programming Language: Java
 */

package com.paco.algorithms.java.leetcode.editor.en;

import java.util.stream.Stream;

public class ReverseWordsInAStringIii {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseWords(String s) {
            return Stream.of(s.split(" "))
                    .map(StringBuffer::new)
                    .map(StringBuffer::reverse)
                    .map(StringBuffer::toString).
                    reduce((a, b) -> a + " " + b)
                    .orElse("");
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}