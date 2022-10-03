package bronze;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Topic: Simulation
 * <p>
 * USACO 2016 January Contest, Bronze
 * <p>
 * Problem 3. Mowing the Field
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=593">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/simulation?lang=java">Topic</a>
 */
public class MowingTheField {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio("mowing");
		int n = io.nextInt();
		Pair cords = new Pair(1000, 1000);
		int[][] map = new int[2001][2001];
		for (int i = 0; i < 2001; i++) {
			Arrays.fill(map[i], -1);
		}
		int distTraveled = 0;
		map[cords.y][cords.x] = distTraveled;
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			char dir = io.next()
			             .charAt(0);
			int steps = io.nextInt();
			while (steps-- > 0) {
				distTraveled++;
				cords.move(dir);
				if (map[cords.y][cords.x] != -1) {
					result = Math.min(result, distTraveled - map[cords.y][cords.x]);
				}
				map[cords.y][cords.x] = distTraveled;
			}
		}
		io.println(result == Integer.MAX_VALUE ? -1 : result);
		io.close();
	}

	@SuppressWarnings("unused")
	static class SolutionForBiggerValues {
		private final static HashMap<Pair, Integer> hashMap = new HashMap<>();

		public static void solve() throws IOException {
			Kattio io = new Kattio("mowing");
			int n = io.nextInt();
			Pair cords = new Pair(0, 0);
			int distTraveled = 0;
			hashMap.put(cords, 0);
			int result = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				char dir = io.next()
				             .charAt(0);
				int steps = io.nextInt();
				while (steps-- > 0) {
					distTraveled++;
					cords.move(dir);
					hashMap.putIfAbsent(cords, distTraveled);
					int prevDist = hashMap.get(cords);
					if (distTraveled != prevDist) {
						result = Math.min(result, distTraveled - prevDist);
					}
					int finalDistTraveled = distTraveled;
					hashMap.compute(cords, (x, y) -> finalDistTraveled);
				}
			}
			io.println(result == Integer.MAX_VALUE ? -1 : result);
			io.close();
		}
	}

	static final class Pair {

		private int x;
		private int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void move(char dir) {
			switch (dir) {
				case 'N' -> y++;
				case 'S' -> y--;
				case 'E' -> x++;
				case 'W' -> x--;
			}
		}

		/**
		 * They have created case for typical hashCode generator.
		 * I had to change it to surpass case 2.
		 */
		@Override
		public int hashCode() {
			return (x + "&!@$!@%21" + y).hashCode();
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}

			Pair pair = (Pair) o;

			if (x != pair.x) {
				return false;
			}
			return y == pair.y;
		}
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