package com.leetcode;

public class GameOfLife {
	class Solution {
		static int[] xMoves = new int[]{
				0,
				1,
				-1
		};
		static int[] yMoves = new int[]{
				0,
				1,
				-1
		};

		public void gameOfLife(int[][] board) {
			game(board);
			repair(board);
		}

		private void game(int[][] board) {
			for (int i = 0; i < board.length; i++) {
				for (int q = 0; q < board[i].length; q++) {
					calculate(i, q, board);
				}
			}
		}

		private void repair(int[][] board) {
			for (int i = 0; i < board.length; i++) {
				for (int q = 0; q < board[i].length; q++) {
					board[i][q] = switch (board[i][q]) {
						case -1, 1 -> 1;
						default -> 0;
					};
				}
			}
		}

		private void calculate(int i, int q, int[][] board) {
			int counter = 0;
			for (int xMove : xMoves) {
				for (int yMove : yMoves) {
					if (xMove == 0 && yMove == 0) {
						continue;
					}
					int x = i + xMove;
					int y = q + yMove;
					if (x >= 0 && x < board.length && y >= 0 && y < board[i].length) {
						if (board[x][y] == 1 || board[x][y] == 2) {
							counter++;
						}
					}
				}
			}
			if (board[i][q] == 0) {
				board[i][q] = counter == 3 ? -1 : 0;
			} else {
				board[i][q] = switch (counter) {
					case 2, 3 -> 1;
					default -> 2;
				};
			}
		}
	}
}