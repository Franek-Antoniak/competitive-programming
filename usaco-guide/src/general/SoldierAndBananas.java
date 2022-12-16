package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Topic: Expected Knowledge
 * <p>
 * Problem A. Soldier and Bananas
 * <p>
 * Problem URL: <a href="https://codeforces.com/problemset/problem/546/A">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/general/expected-knowledge?lang=java">Topic</a>
 */
public class SoldierAndBananas {
	private static final PrintWriter pw = new PrintWriter(System.out);
	private static final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(r.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int result = (c * (c + 1)) / 2 * a;
		pw.print(Math.max(result - b, 0));
		pw.close();
	}
}