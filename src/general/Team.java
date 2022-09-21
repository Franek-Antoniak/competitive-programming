package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Topic: Expected Knowledge - Introductory USACO Bronze Problems
 * <p>
 * Problem: A. Team
 * <p>
 * Problem URL: <a href="https://codeforces.com/problemset/problem/231/A">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/general/expected-knowledge?lang=java">Topic</a>
 */
public class Team {

    private static int solve() throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int result =
                Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        return result >= 2 ? 1 : 0;
    }

    private static final PrintWriter pw = new PrintWriter(System.out);
    private static final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int result = 0, input = Integer.parseInt(new StringTokenizer(r.readLine()).nextToken());
        for (int i = 0; i < input; i++) {
            result += solve();
        }
        pw.println(result);
        pw.close();
    }
}