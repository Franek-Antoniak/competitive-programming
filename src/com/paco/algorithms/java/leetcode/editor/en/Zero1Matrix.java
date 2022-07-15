/**
 * Solved by Paco
 * Date: 2022-07-08 17:14:04
 * Exercise number: 542
 * Title: 01-matrix
 * Proramming Language: Java
 */

//Given an m x n binary matrix mat, return the distance of the nearest 0 for 
//each cell. 
//
// The distance between two adjacent cells is 1. 
//
// 
// Example 1: 
//
// 
//Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
//Output: [[0,0,0],[0,1,0],[0,0,0]]
// 
//
// Example 2: 
//
// 
//Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
//Output: [[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
// Constraints: 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// mat[i][j] is either 0 or 1. 
// There is at least one 0 in mat. 
// 
// 👍 5017 👎 244


package com.paco.algorithms.java.leetcode.editor.en;

import java.util.Arrays;

public class Zero1Matrix {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution { // 5 ms, faster than 99.66%
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length, INF = m + n; // The distance of cells is up to (M+N)
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (mat[r][c] == 0) continue;
                    int top = INF, left = INF;
                    if (r - 1 >= 0) top = mat[r - 1][c];
                    if (c - 1 >= 0) left = mat[r][c - 1];
                    mat[r][c] = Math.min(top, left) + 1;
                }
            }
            for (int r = m - 1; r >= 0; r--) {
                for (int c = n - 1; c >= 0; c--) {
                    if (mat[r][c] == 0) continue;
                    int bottom = INF, right = INF;
                    if (r + 1 < m) bottom = mat[r + 1][c];
                    if (c + 1 < n) right = mat[r][c + 1];
                    mat[r][c] = Math.min(mat[r][c], Math.min(bottom, right) + 1);
                }
            }
            return mat;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}