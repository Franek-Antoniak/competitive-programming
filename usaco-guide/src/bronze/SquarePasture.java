package bronze;

import java.io.*;
import java.util.Arrays;


/**
 * Topic: Rectangle Geometry
 * <p>
 * USACO 2016 December Contest, Bronze
 * <p>
 * Problem 1. Square Pasture
 * <p>
 * Problem URL: <a href="https://usaco.guide/bronze/rect-geo?lang=java#problem-usaco-663">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/rect-geo?lang=java">Topic</a>
 */
public class SquarePasture {

	private static final PrintWriter pw;
	private static final BufferedReader r;

	static {
		try {
			r = new BufferedReader(new FileReader("square.in"));
			pw = new PrintWriter("square.out");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws IOException {
		solve();
		pw.close();
	}

	private static void solve() throws IOException {
		int[] first = Arrays.stream(r.readLine()
		                             .split(" "))
		                    .mapToInt(Integer::parseInt)
		                    .toArray();
		int[] second = Arrays.stream(r.readLine()
		                              .split(" "))
		                     .mapToInt(Integer::parseInt)
		                     .toArray();
		long maxLength = Math.max(Math.max(first[2], second[2]) - Math.min(first[0], second[0]),
				Math.max(first[3], second[3]) - Math.min(first[1], second[1]));
		pw.print(maxLength * maxLength);
	}
}