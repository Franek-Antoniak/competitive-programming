package bronze;

import java.io.*;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Topic: Simulation
 * <p>
 * USACO 2018 US Open Contest, Bronze
 * <p>
 * Problem 1. Team Tic Tac Toe
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=831">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/simulation/?lang=java">Topic</a>
 */
public class TeamTicTacToe {
	private static final Set<Character> singleCow = new TreeSet<>();
	private static final Set<String> teams = new TreeSet<>();

	public static void main(String[] args) throws IOException {
		char[][] board = new char[3][3];
		Kattio io = new Kattio("tttt");
		for (int i = 0; i < 3; i++) {
			board[i] = io.next()
			             .toCharArray();
		}
		for (int i = 0; i < 3; i++) {
			checkWin(board[i][0], board[i][1], board[i][2]);
			checkWin(board[0][i], board[1][i], board[2][i]);
		}
		checkWin(board[0][0], board[1][1], board[2][2]);
		checkWin(board[0][2], board[1][1], board[2][0]);
		io.println(singleCow.size());
		io.println(teams.size());
		io.close();
	}

	private static void checkWin(char a, char b, char c) {
		TreeSet<Character> set = new TreeSet<>(List.of(a, b, c));
		if (set.size() == 3) {
			return;
		}
		if (set.size() == 1) {
			singleCow.add(a);
			return;
		}
		teams.add(set.first() + "" + set.last());
	}

	@SuppressWarnings("unused")
	static class Kattio extends PrintWriter {
		private final BufferedReader r;
		private StringTokenizer st;

		// standard input
		public Kattio() {
			this(System.in, System.out);
		}

		public Kattio(InputStream i, OutputStream o) {
			super(o);
			r = new BufferedReader(new InputStreamReader(i));
		}

		// USACO-style file input
		public Kattio(String problemName) throws IOException {
			super(problemName + ".out");
			r = new BufferedReader(new FileReader(problemName + ".in"));
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		// returns null if no more input
		public String next() {
			try {
				while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(r.readLine());
				return st.nextToken();
			} catch (Exception ignored) {
			}
			return null;
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
