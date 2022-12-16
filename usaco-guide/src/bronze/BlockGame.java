package bronze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Topic: Simulation
 * <p>
 * USACO 2016 December Contest, Bronze
 * <p>
 * Problem 2. Block Game
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=664">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/simulation?lang=java">Topic</a>
 */

public class BlockGame {

	public static void main(String[] args) throws IOException {
		try (Kattio io = new Kattio("blocks")) {
			int n = io.nextInt();
			int[] answer = new int[26];
			for (int i = 0; i < n; i++) {
				addMaxFreq(answer, countChars(io.next()), countChars(io.next()));
			}
			for (int i : answer) {
				io.println(i);
			}
		}
	}

	private static void addMaxFreq(int[] answer, int[] freq1, int[] freq2) {
		for (int i = 0; i < answer.length; i++) {
			answer[i] += Math.max(freq1[i], freq2[i]);
		}
	}

	private static int[] countChars(String word) {
		int[] freq = new int[26];
		for (int i = 0; i < word.length(); i++) {
			freq[word.charAt(i) - 'a']++;
		}
		return freq;
	}

	static class Kattio extends PrintWriter {
		private final BufferedReader r;
		private StringTokenizer st;

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
	}
}