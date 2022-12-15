/**
 * Solved by Paco
 * Date: 2022-07-08 17:12:10
 * Exercise number: 733
 * Title: flood-fill
 * Programming Language: Java
 */


package com.leetcode;

public class FloodFill {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] floodFill(int[][] image, int sr, int sc, int color) {
            if (image[sr][sc] == color) {
                return image;
            }
            colorImage(image, sr, sc, color, image[sr][sc]);
            return image;
        }

        private void colorImage(int[][] image, int sr, int sc, int color, int base_color) {
            image[sr][sc] = color;
            if (sr + 1 < image.length && image[sr + 1][sc] == base_color)
                colorImage(image, sr + 1, sc, color, base_color);
            if (sr - 1 >= 0 && image[sr - 1][sc] == base_color)
                colorImage(image, sr - 1, sc, color, base_color);
            if (sc + 1 < image[sr].length && image[sr][sc + 1] == base_color)
                colorImage(image, sr, sc + 1, color, base_color);
            if (sc - 1 >= 0 && image[sr][sc - 1] == base_color)
                colorImage(image, sr, sc - 1, color, base_color);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}