package bronze;

import java.io.*;
import java.util.*;

/**
 * Topic: Simulation
 * <p>
 * USACO 2020 December Contest, Bronze
 * <p>
 * Problem 3. Stuck in a Rut
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=1061">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/simulation?lang=java">Topic</a>
 */
public class StuckInARut {
	public static void main(String[] args) throws IOException {
		Kattio io = new Kattio();
		int n = io.nextInt();
		List<int[]> northCows = new ArrayList<>();
		List<int[]> eastCows = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (io.next().equals("N")) {
				northCows.add(new int[]{io.nextInt(), io.nextInt(), i});
			} else {
				eastCows.add(new int[]{io.nextInt(), io.nextInt(), i});
			}
		}
		eastCows.sort(Comparator.comparingInt(o -> o[1]));
		northCows.sort(Comparator.comparingInt(o -> o[0]));
		// stores locations of stopped cows
		int[] stoppedLocations = new int[n];
		Arrays.fill(stoppedLocations, -1);
		// check every combination of cows
		for (int[] northCow : northCows) {
			for (int[] eastCow : eastCows) {
				/*
				 * The north cows can't move down, and the east cows
				 * can't move backwards, so a north cow's x coordinate must
				 * be less than an east cow's x coordinate, and a north
				 * cow's y coordinate must be less than an east cow's y coordinate
				 * for them to collide.
				 */
				if (northCow[0] > eastCow[0] && northCow[1] < eastCow[1]) {
					// Distance they travel
					int northDistance = eastCow[1] - northCow[1];
					int eastDistance = northCow[0] - eastCow[0];
					/*
					 * If the north cow gets to the meeting place before
					 * the east cow and the east cow has not been stopped
					 * already,
					 */
					if (northDistance < eastDistance && stoppedLocations[eastCow[2]] == -1) {
						/*
						 * then we can set the east cow's stopping point.
						 * We only save the x coordinate because the y coordinate
						 * stays constant.
						 */
						stoppedLocations[eastCow[2]] = northCow[0];
					}

					/*
					 * If the east cow gets there before,
					 * we can save the north cow's position.
					 */
					if (northDistance > eastDistance && stoppedLocations[eastCow[2]] == -1) {
						stoppedLocations[northCow[2]] = eastCow[1];
						/*
						 * We iterate per north cow, so we can move on to the
						 * next north cow if this cow can't move anymore
						 */
						break;
					}
				}
			}
		}

		// Tracks distance traveled.
		int[] distances = new int[n];
		Arrays.fill(distances, -1);
		for (int[] northCow : northCows) {
			/*
			 * If this array element hasn't been touched,
			 * the cow never stops and eats forever.
			 */
			if (stoppedLocations[northCow[2]] != -1) {
				// Eaten is (current position - original position)
				distances[northCow[2]] = stoppedLocations[northCow[2]] - northCow[1];
			}

		}

		for (int[] eastCow : eastCows) {
			if (stoppedLocations[eastCow[2]] != -1) {
				distances[eastCow[2]] = stoppedLocations[eastCow[2]] - eastCow[0];
			}
		}

		for (int x : distances) {
			// Ternary operator
			io.println(x == -1 ? "Infinity" : x);
		}
		io.close();
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