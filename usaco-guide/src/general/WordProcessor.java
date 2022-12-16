package general;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * Topic: Expected Knowledge - Introductory USACO Bronze Problems
 * <p>
 * USACO 2020 January Contest, Bronze
 * <p>
 * Problem 1. Word Processor
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=987">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/general/expected-knowledge?lang=java">Topic</a>
 */
public class WordProcessor {

	private static final PrintWriter pw;
	private static final BufferedReader r;

	static {
		try {
			pw = new PrintWriter("word.out");
			r = new BufferedReader(new FileReader("word.in"));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws IOException {
		solve();
		pw.close();
	}

	private static void solve() throws IOException {
		StringTokenizer stringTokenizer = new StringTokenizer(r.readLine());
		stringTokenizer.nextToken();
		int k = Integer.parseInt(stringTokenizer.nextToken());
		String s = r.readLine();
		pw.print(Arrays.stream(s.split(" "))
		               .reduce((x, y) -> {
			               String newString = x.concat(" " + y);
			               if (newString.replace(" ", "")
			                            .length() <= k) {
				               return newString;
			               }
			               pw.println(x);
			               return y;
		               })
		               .orElse(""));
	}
}