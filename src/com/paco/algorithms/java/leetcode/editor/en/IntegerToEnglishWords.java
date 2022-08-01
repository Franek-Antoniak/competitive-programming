/**
 * Solved by Paco
 * Date: 2022-07-24 20:16:39
 * Exercise number: 273
 * Title: integer-to-english-words
 * Programming Language: Java
 */


package com.paco.algorithms.java.leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class IntegerToEnglishWords {

    // Solution created by me
    // Time complexity: O(log10(n)) where n is the number of digits in the number
    // Space complexity: O(1)
    // The fastest O(log10(n)) solution needs to store the number in words and iterate over them to build the result
    // string.
    // leetcode info:
    // The fastest time I could achieve with this code on leetcode is 20 ms.
    // Runtime:21 ms, faster than 22.91% of Java online submissions.
    // Memory Usage:44 MB, less than 6.37% of Java online submissions.
    class MyOwnSolution {
        private final String[] digitToWord = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
        private final String[] teenaToWord = {"", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        private final String[] counterToPrefixes = {"", "", "", "Hundred ", "Thousand ", "", "Hundred ", "Million ", "", "Hundred ", "Billion "};
        private final String[] tensToWord = {"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy" + " ", "Eighty ", "Ninety "};

        public static String reverseWordsInString(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            Arrays.stream(str.split("\\s+"))
                    .collect(Collectors.toCollection(LinkedList::new))
                    .descendingIterator()
                    .forEachRemaining(x -> stringBuilder.append(x)
                            .append(" "));
            return stringBuilder.toString()
                    .trim();
        }

        public String numberToWords(int num) {
            StringBuilder stringBuilder = new StringBuilder();
            if (num == 0) {
                return "Zero";
            }
            int counter = 1;
            while (num != 0) {
                int x = num % 10;
                int y = num / 10 == 0 ? -1 : (num / 10) % 10;
                int z = num / 100 == 0 ? -1 : (num / 100) % 10;
                num /= 1000;
                stringBuilder.append(partNumberToWord(z, y, x, counter));
                counter += 3;
            }
            return reverseWordsInString(stringBuilder.toString()
                    .trim());
        }

        private String partNumberToWord(int digit1, int digit2, int digit3, int counter) {
            StringBuilder stringBuilder = new StringBuilder();
            if (digit3 == 0 && digit2 != 0) {
                stringBuilder.append(counterToPrefixes[counter])
                        .append(tensToWord[digit2]);
            } else if (digit2 == 1) {
                stringBuilder.append(counterToPrefixes[counter])
                        .append(teenaToWord[digit3]);
            } else if (digit2 != 0 && digit2 != -1) {
                stringBuilder.append(counterToPrefixes[counter])
                        .append(digitToWord[digit3])
                        .append(tensToWord[digit2]);
            } else if (digit3 != 0) {
                stringBuilder.append(counterToPrefixes[counter])
                        .append(digitToWord[digit3]);
            }
            if (digit2 == 0 && digit3 == 0 && digit1 != 0) stringBuilder.append(counterToPrefixes[counter]);
            if (digit1 != -1 && digit1 != 0) {
                stringBuilder.append(counterToPrefixes[counter + 2])
                        .append(digitToWord[digit1]);
            }
            return stringBuilder.toString();
        }
    }


    // Solution created by leetcode user and modified by me
    // Time complexity: O(log10(n)) where n is the number of digits in the number
    // Its more optimized than my own solution due to the use of recursion
    // Space complexity: O(log10(n)) where n is the number of digits in the number due to the use of recursion
    // In terms of ms, it is faster 10x times in most of the cases or even more than my own solution
    // I still did some code clean up and changed it to look more understandable
    // I reduced some boilerplate code and made it more readable
    // The fastest time I could achieve with this code on leetcode is 2 ms.
    // leetcode info:
    // Runtime:2 ms, faster than 99.56% of Java online submissions.
    // Memory Usage:40.3 MB, less than 99.32% of Java online submissions.
    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final int BILLION = 1000000000;
        private final int MILLION = 1000000;
        private final String[] LESS_THAN_10 = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        private final String[] LESS_THAN_100 = {"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};

        public String numberToWords(int num) {
            if (num == 0) return "Zero";
            StringBuilder builder = new StringBuilder();
            helper(num, builder);
            return builder.toString()
                    .trim();
        }

        private Pair<Integer, String> getHelperPair(int num) {
            if (num >= BILLION) return new Pair<>(BILLION, "Billion ");
            if (num >= MILLION) return new Pair<>(MILLION, "Million ");
            if (num >= 1000) return new Pair<>(1000, "Thousand ");
            return new Pair<>(100, "Hundred ");
        }

        private void helper(int num, StringBuilder builder) {
            if (num == 0) return;
            if (num >= 20 && num < 100) {
                builder.append(LESS_THAN_100[num / 10]);
                helper(num % 10, builder);
            } else if (num <= 20) builder.append(LESS_THAN_10[num]);
            else {
                var helperPair = getHelperPair(num);
                helper(num / helperPair.key(), builder);
                builder.append(helperPair.value());
                helper(num % helperPair.key(), builder);
            }
        }

        record Pair<K, V>(K key, V value) {
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
