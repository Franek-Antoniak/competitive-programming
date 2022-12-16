package bronze;

import java.io.*;
import java.util.StringTokenizer;


/**
 * Topic: Simulation
 * <p>
 * USACO 2015 December Contest, Bronze
 * <p>
 * Problem 2. Speeding Ticket
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=568">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/simulation?lang=java">Topic</a>
 */
public class SpeedingTicket {
	private static final PrintWriter pw;
	private static final BufferedReader r;

	static {
		try {
			r = new BufferedReader(new FileReader("speeding.in"));
			pw = new PrintWriter("speeding.out");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws IOException {
		solve();
		pw.close();
	}

	private static void solve() throws IOException {
		StringTokenizer st = new StringTokenizer(r.readLine());
		Road[] roads = new Road[Integer.parseInt(st.nextToken()) + 1];
		roads[0] = new Road(0, 0);
		int m = Integer.parseInt(st.nextToken());
		for (int i = 1; i < roads.length; i++) {
			st = new StringTokenizer(r.readLine());
			roads[i] = new Road(Integer.parseInt(st.nextToken()) + roads[i - 1].where,
					Integer.parseInt(st.nextToken()));
		}
		int result = 0, counter = 0, j = 1;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(r.readLine());
			Road road = new Road(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			// Driving from counter to counter + road.where
			boolean isAboveRange = true, isInRange;
			while (j < roads.length && isAboveRange) {
				isAboveRange = inRange(roads[j].where, counter, counter + road.where);
				isInRange = inRange(counter + road.where, roads[j - 1].where, roads[j].where);
				if (isAboveRange) {
					result = Math.max(result, road.speedLimit - roads[j++].speedLimit);
				} else if (isInRange) {
					result = Math.max(result, road.speedLimit - roads[j].speedLimit);
				}
			}
			counter += road.where;
		}
		pw.print(result);
	}

	private static boolean inRange(int what, int range1, int range2) {
		return range1 < what && what <= range2;
	}

	record Road(int where, int speedLimit) {
	}
}