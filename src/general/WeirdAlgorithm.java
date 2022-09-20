package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Topic: Input & Output
 * <p>
 * Problem: Weird Algorithm
 * <p>
 * Problem URL: <a href="https://cses.fi/problemset/task/1068/">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/general/input-output?lang=java">Topic</a>
 */
public class WeirdAlgorithm {
    private static final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int a = Integer.parseInt(st.nextToken());
        solve(a);
        pw.close();
    }

    private static void solve(long a) {
        if (a == 1) {
            pw.print(1);
            return;
        }
        pw.print(a + " ");
        if (a % 2 == 1) {
            solve(a * 3 + 1);
            return;
        }
        solve(a / 2);
    }
}