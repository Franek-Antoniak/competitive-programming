package general;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Topic: Expected Knowledge
 * <p>
 * USACO 2018 February Contest, Bronze
 * <p>
 * Problem 1. Teleportation
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=807">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/general/expected-knowledge?lang=java">Topic</a>
 */
public class Teleportation {

	public static void main(String[] args) throws IOException {
		PrintWriter pw = new PrintWriter("teleport.out");
		BufferedReader r = new BufferedReader(new FileReader("teleport.in"));
		StringTokenizer st = new StringTokenizer(r.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		pw.print(solve(a, b, c, d));
		pw.close();
	}

	private static int solve(int a, int b, int c, int d) {
		int fSol = Math.abs(a - b);
		int sSol;
		if (Math.abs(c - a) < Math.abs(d - a)) sSol = Math.abs(c - a) + Math.abs(d - b);
		else sSol = Math.abs(d - a) + Math.abs(c - b);
		return Math.min(fSol, sSol);
	}
}