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

    // Main method
    public static void main(String[] args) {
        Solution solution = new IntegerToEnglishWords().new Solution();
        System.out.println(solution.numberToWords(1234567));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final String[] digitToWord = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
        private final String[] teenaToWord = {"", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ",
                "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        private final String[] counterToPrefixes = {"", "", "", "Hundred ", "Thousand ", "", "Hundred ", "Million ", "", "Hundred ", "Billion "};
        private final String[] tensToWord = {"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy" +
                " ", "Eighty ", "Ninety "};

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
                num /= 10;
                int y = num == 0 ? -1 : num % 10;
                num /= 10;
                int z = num == 0 ? -1 : num % 10;
                num /= 10;
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
            if (digit2 == 0 && digit3 == 0 && digit1 != 0)
                stringBuilder.append(counterToPrefixes[counter]);
            if (digit1 != -1 && digit1 != 0) {
                stringBuilder
                        .append(counterToPrefixes[counter + 2])
                        .append(digitToWord[digit1]);
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
