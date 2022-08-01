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
                stringBuilder.append(counterToPrefixes(counter))
                        .append(tensToWord(digit2));
            } else if (digit2 == 1) {
                stringBuilder.append(counterToPrefixes(counter))
                        .append(teenaToWord(digit3));
            } else if (digit2 != 0 && digit2 != -1) {
                stringBuilder.append(counterToPrefixes(counter))
                        .append(digitToWord(digit3))
                        .append(tensToWord(digit2));
            } else if (digit3 != 0) {
                stringBuilder.append(counterToPrefixes(counter))
                        .append(digitToWord(digit3));
            }
            if (digit2 == 0 && digit3 == 0 && digit1 != 0)
                stringBuilder.append(counterToPrefixes(counter));
            if (digit1 != -1 && digit1 != 0) {
                stringBuilder
                        .append(counterToPrefixes(counter + 2))
                        .append(digitToWord(digit1));
            }
            return stringBuilder.toString();
        }

        public String counterToPrefixes(int counter) {
            return switch (counter) {
                case 3, 9, 6 -> "Hundred ";
                case 4 -> "Thousand ";
                case 7 -> "Million ";
                case 10 -> "Billion ";
                default -> "";
            };
        }

        public String teenaToWord(int i) {
            return switch (i) {
                case 1 -> "Eleven ";
                case 2 -> "Twelve ";
                case 3 -> "Thirteen ";
                case 4 -> "Fourteen ";
                case 5 -> "Fifteen ";
                case 6 -> "Sixteen ";
                case 7 -> "Seventeen ";
                case 8 -> "Eighteen ";
                case 9 -> "Nineteen ";
                default -> "";
            };
        }

        public String digitToWord(int digit) {
            return switch (digit) {
                case 1 -> "One ";
                case 2 -> "Two ";
                case 3 -> "Three ";
                case 4 -> "Four ";
                case 5 -> "Five ";
                case 6 -> "Six ";
                case 7 -> "Seven ";
                case 8 -> "Eight ";
                case 9 -> "Nine ";
                default -> "";
            };
        }

        public String tensToWord(int tens) {
            return switch (tens) {
                case 1 -> "Ten ";
                case 2 -> "Twenty ";
                case 3 -> "Thirty ";
                case 4 -> "Forty ";
                case 5 -> "Fifty ";
                case 6 -> "Sixty ";
                case 7 -> "Seventy ";
                case 8 -> "Eighty ";
                case 9 -> "Ninety ";
                default -> "";
            };
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
