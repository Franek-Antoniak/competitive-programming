package bronze;

import java.io.*;


/**
 * Topic: Simulation
 * <p>
 * USACO 2016 February Contest, Bronze
 * <p>
 * Problem 2. Circular Barn
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=616">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/simulation?lang=java">Topic</a>
 */
public class CircularBarn {

	private static PrintWriter pw;
	private static BufferedReader r;

	private static void solve() throws IOException {
		int n = Integer.parseInt(r.readLine());
		int sumToMin = 0, realSum = 0;
		int[] tab = new int[n];
		for (int i = 0; i < n; i++) {
			tab[i] = Integer.parseInt(r.readLine());
			sumToMin += tab[i] * i;
			realSum += tab[i];
		}
		int result = sumToMin;
		for (int i = 1; i < n; i++) {
			sumToMin += n * tab[i - 1] - realSum;
			result = Math.min(result, sumToMin);
		}
		pw.println(result);
	}

	private static void initIO() {
		String fileName = "cbarn";
		try {
			r = new BufferedReader(new FileReader(fileName + ".in"));
			pw = new PrintWriter(fileName + ".out");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws IOException {
		initIO();
		solve();
		pw.close();
	}
}