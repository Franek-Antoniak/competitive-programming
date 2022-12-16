package bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Topic: Simulation
 * <p>
 * USACO 2017 December Contest, Bronze
 * <p>
 * Problem 3. Milk Measurement
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=761">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/simulation?lang=java">Topic</a>
 */
public class MilkMeasurement {

	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("measurement");
		int n = io.nextInt();
		int[][] list = new int[100][3];
		for (int i = 0; i < n; i++) {
			int day = io.nextInt() - 1, indexName = getNameIndex(io.next()), milk = io.nextInt();
			list[day][indexName] = milk;
		}
		int result = 0;
		int[] milkRecords = {7, 7, 7};
		for (int i = 0; i < 100; i++) {
			result += getChanges(milkRecords, list[i]);
		}
		io.println(result);
		io.close();
	}

	private static int getNameIndex(String name) {
		return name.equals("Bessie") ? 0 : (name.equals("Mildred") ? 1 : 2);
	}

	private static int getChanges(int[] milkRecords, int[] changes) {
		int[] winnersA = getWinners(milkRecords, Arrays.stream(milkRecords)
		                                               .max()
		                                               .orElse(-1));
		addChanges(milkRecords, changes);
		int[] winnersB = getWinners(milkRecords, Arrays.stream(milkRecords)
		                                               .max()
		                                               .orElse(-1));
		return isWinnersChanged(winnersA, winnersB);
	}

	private static int[] getWinners(int[] milkRecords, int max) {
		int[] winners = new int[3];
		for (int i = 0; i < milkRecords.length; i++) {
			if (milkRecords[i] == max) {
				winners[i] = 1;
			}
		}
		return winners;
	}

	private static void addChanges(int[] milkRecords, int[] changes) {
		for (int i = 0; i < milkRecords.length; i++) {
			milkRecords[i] += changes[i];
		}
	}

	private static int isWinnersChanged(int[] winnersA, int[] winnersB) {
		for (int i = 0; i < 3; i++) {
			if (winnersA[i] != winnersB[i]) {
				return 1;
			}
		}
		return 0;
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