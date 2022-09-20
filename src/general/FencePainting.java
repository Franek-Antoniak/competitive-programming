package general;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Topic: Input & Output
 * <p>
 * Problem: USACO 2015 December Contest, Bronze
 * <p>
 * Problem 1. Fence Painting
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=567">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/general/input-output?lang=java">Topic</a>
 */
public class FencePainting {
    private static PrintWriter pw;

    private static int solve(int a, int b, int c, int d) {
        if (c > a) {
            if (b < c) return b - a + d - c;
            // b > c
            if (b > d) return b - a;
            return d - a;
        }
        // a > c
        if (d < a)
            return d - c + b - a;
        if (d < b) return b - c;
        return d - c;

    }

    public static void main(String[] args) throws IOException {
        pw = new PrintWriter("paint.out");
        BufferedReader r = new BufferedReader(new FileReader("paint.in"));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        pw.print(solve(a, b, c, d));
        pw.close();
    }
}