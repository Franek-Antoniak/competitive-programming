package general;

import java.io.*;


/**
 * Topic: Expected Knowledge - Introductory USACO Bronze Problems
 * <p>
 * USACO 2019 US Open Contest, Bronze
 * <p>
 * Problem 1. Bucket Brigade
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=939">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/general/expected-knowledge?lang=java">Topic</a>
 */
public class BucketBridge {

	private static final PrintWriter pw;
	private static final BufferedReader r;

	static {
		try {
			r = new BufferedReader(new FileReader("buckets.in"));
			pw = new PrintWriter("buckets.out");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws IOException {
		solve();
		pw.close();
	}

	private static void solve() throws IOException {
		char[][] grid = new char[10][10];
		int xB = 0, yB = 0, xL = 0, yL = 0, xR = 0, yR = 0;
		for (int i = 0; i < 10; i++) {
			grid[i] = r.readLine()
			           .toCharArray();
			for (int j = 0; j < 10; j++) {
				if (grid[i][j] == 'B') {
					xB = i;
					yB = j;
				} else if (grid[i][j] == 'L') {
					xL = i;
					yL = j;
				} else if (grid[i][j] == 'R') {
					xR = i;
					yR = j;
				}
			}
		}
		if ((xB == xL && xB == xR)) {
			if ((yL < yR && yR < yB) || (yL > yR && yR > yB)) {
				pw.print(Math.abs(yB - yL) + 1);
				return;
			}
		} else if (yB == yL && yB == yR) {
			if ((xL < xR && xR < xB) || (xL > xR && xR > xB)) {
				pw.print(Math.abs(xB - xL) + 1);
				return;
			}
		}
		pw.print(Math.abs(xB - xL) + Math.abs(yB - yL) - 1);
	}
}