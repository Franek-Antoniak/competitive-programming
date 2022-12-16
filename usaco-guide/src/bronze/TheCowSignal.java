package bronze;

import java.io.*;
import java.util.Arrays;


/**
 * Topic: Simulation
 * <p>
 * USACO 2016 December Contest, Bronze
 * <p>
 * Problem 3. The Cow-Signal
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=665">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/simulation?lang=java">Topic</a>
 */
public class TheCowSignal {

	private static final PrintWriter pw;
	private static final BufferedReader r;

	static {
		try {
			r = new BufferedReader(new FileReader("cowsignal.in"));
			pw = new PrintWriter("cowsignal.out");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws IOException {
		solve();
		pw.close();
	}

	private static void solve() throws IOException {
		int[] input = Arrays.stream(r.readLine()
		                             .split(" "))
		                    .mapToInt(Integer::parseInt)
		                    .toArray();
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < input[0]; i++) {
			stringBuilder.append(Arrays.stream(r.readLine()
			                                    .split(""))
			                           .map(x -> x.repeat(input[2]))
			                           .reduce(String::concat)
			                           .orElse("Error")
			                           .concat("\n")
			                           .repeat(input[2]));
		}
		pw.print(stringBuilder);
	}
}