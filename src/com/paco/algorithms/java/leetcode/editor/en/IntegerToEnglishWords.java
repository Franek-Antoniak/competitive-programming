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
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public static String reverseWordsInString(String str) {
            StringBuilder stringBuilder = new StringBuilder();
            Arrays.stream(str.split("\\s+"))
                    .collect(Collectors.toCollection(LinkedList::new))
                    .descendingIterator()
                    .forEachRemaining(stringBuilder::append);
            return stringBuilder.toString();
        }

        public String numberToWords(int num) {
            StringBuilder stringBuilder = new StringBuilder();
            int counter = 1;
            while (num != 0) {
                stringBuilder.append(partNumberToWord(num % 10, counter, num));
                stringBuilder.append(" ");
                num /= 10;
                counter++;
            }
            return reverseWordsInString(stringBuilder.toString()
                    .trim());
        }

        private String partNumberToWord(int i, int counter, int num) {
            return switch (counter) {
                case 1 -> digitToWord(i);
                case 2, 5, 8 -> tensToWord(i);
                case 3, 9, 6 -> "Hundred " + digitToWord(i);
                case 4 -> "Thousand " + digitToWord(i);
                case 7 -> "Million " + digitToWord(i);
                case 10 -> "Billion " + digitToWord(i);
                default -> "";
            };
        }

        public String digitToWord(int digit) {
            return switch (digit) {
                case 0 -> "Zero";
                case 1 -> "One";
                case 2 -> "Two";
                case 3 -> "Three";
                case 4 -> "Four";
                case 5 -> "Five";
                case 6 -> "Six";
                case 7 -> "Seven";
                case 8 -> "Eight";
                case 9 -> "Nine";
                default -> "";
            };
        }

        public String tensToWord(int tens) {
            return switch (tens) {
                case 1 -> "Ten";
                case 2 -> "Twenty";
                case 3 -> "Thirty";
                case 4 -> "Forty";
                case 5 -> "Fifty";
                case 6 -> "Sixty";
                case 7 -> "Seventy";
                case 8 -> "Eighty";
                case 9 -> "Ninety";
                default -> "";
            };
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
