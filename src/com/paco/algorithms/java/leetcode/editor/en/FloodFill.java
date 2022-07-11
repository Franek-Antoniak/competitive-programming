/**
 * Solved by Paco
 * Date: 2022-07-08 17:12:10
 * Exercise number: 733
 * Title: flood-fill
 * Proramming Language: Java
 */

//An image is represented by an m x n integer grid image where image[i][j] 
//represents the pixel value of the image. 
//
// You are also given three integers sr, sc, and color. You should perform a 
//flood fill on the image starting from the pixel image[sr][sc]. 
//
// To perform a flood fill, consider the starting pixel, plus any pixels 
//connected 4-directionally to the starting pixel of the same color as the starting 
//pixel, plus any pixels connected 4-directionally to those pixels (also with the same 
//color), and so on. Replace the color of all of the aforementioned pixels with 
//color. 
//
// Return the modified image after performing the flood fill. 
//
// 
// Example 1: 
//
// 
//Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
//Output: [[2,2,2],[2,2,0],[2,0,1]]
//Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.
//e., the red pixel), all pixels connected by a path of the same color as the 
//starting pixel (i.e., the blue pixels) are colored with the new color.
//Note the bottom corner is not colored 2, because it is not 4-directionally 
//connected to the starting pixel.
// 
//
// Example 2: 
//
// 
//Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
//Output: [[0,0,0],[0,0,0]]
//Explanation: The starting pixel is already colored 0, so no changes are made 
//to the image.
// 
//
// 
// Constraints: 
//
// 
// m == image.length 
// n == image[i].length 
// 1 <= m, n <= 50 
// 0 <= image[i][j], color < 2¹⁶ 
// 0 <= sr < m 
// 0 <= sc < n 
// 
// 👍 4686 👎 448


package com.paco.algorithms.java.leetcode.editor.en;

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