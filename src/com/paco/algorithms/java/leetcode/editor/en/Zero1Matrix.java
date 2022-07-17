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

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Zero1Matrix {

    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class BFSSolution {
        public int[][] updateMatrix(int[][] mat) {
            int rows = mat.length;
            if (rows == 0) return mat;
            int cols = mat[0].length;
            int[][] dist = new int[rows][cols];
            // Filled with maximum value to make sure it is larger than any other distance
            for (int[] ints : dist) {
                Arrays.fill(ints, rows + cols);
            }
            Deque<Pair> queue = new ArrayDeque<>();
            // Filling queue with 0's existing in matrix
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (mat[i][j] == 0) {
                        dist[i][j] = 0;
                        queue.offer(new Pair(i, j));
                    }
                }
            }
            // Trick to not make so many if statements
            // Directions are: bottom, top, left, right
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            while (!queue.isEmpty()) {
                Pair cur = queue.poll();
                for (int[] direction : directions) {
                    int x = cur.x + direction[0];
                    int y = cur.y + direction[1];
                    if (x < 0 || x >= rows || y < 0 || y >= cols) continue;
                    if (dist[x][y] > dist[cur.x][cur.y] + 1) {
                        dist[x][y] = dist[cur.x][cur.y] + 1;
                        queue.offer(new Pair(x, y));
                    }
                }
            }
            return dist;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution { // 5 ms, faster than 99.66%
        public int[][] updateMatrix(int[][] mat) {
            int m = mat.length, n = mat[0].length, INF = m + n; // The distance of cells is up to (M+N)
            int[][] dist = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = mat[i][j] == 0 ? 0 : INF;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mat[i][j] == 0) continue;
                    if (i > 0) dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    if (j > 0) dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
            for (int i = m - 1; i >= 0; i--) {
                for (int j = n - 1; j >= 0; j--) {
                    if (mat[i][j] == 0) continue;
                    if (i < m - 1) dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                    if (j < n - 1) dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                }
            }
            return dist;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)

}