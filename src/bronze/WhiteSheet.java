package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


/**
 * Topic: Rectangle Geometry
 * <p>
 * Codeforces Round #587 (Div. 3)
 * <p>
 * Problem C. White Sheet
 * <p>
 * Problem URL: <a href="https://codeforces.com/contest/1216/problem/C">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/rect-geo?lang=java">Topic</a>
 */
public class WhiteSheet {

    private static boolean solve() throws IOException {
        int[][] rects = new int[3][4];
        for (int i = 0; i < 3; i++) {
            rects[i] = Arrays.stream(r.readLine()
                            .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        for (int i = 1; i < 3; i++)
            rects[i] = intersection(rects, 0, i);
        return (getArea(rects[0]) - getArea(rects[1]) - getArea(rects[2]) + getArea(intersection(rects, 1, 2))) > 0;
    }

    private static int[] intersection(int[][] rects, int v, int q) {
        if (rects[v] == null || rects[q] == null)
            return null;
        int x2 = Math.min(rects[v][2], rects[q][2]),
                x1 = Math.max(rects[v][0], rects[q][0]),
                y2 = Math.min(rects[v][3], rects[q][3]),
                y1 = Math.max(rects[v][1], rects[q][1]);
        if (x2 < x1 || y2 < y1) return null;
        return new int[]{x1, y1, x2, y2};
    }

    private static long getArea(int[] rect) {
        if (rect == null)
            return 0;
        return (long) Math.max(rect[2] - rect[0], 0) * Math.max(rect[3] - rect[1], 0);
    }

    private static final PrintWriter pw = new PrintWriter(System.out);
    private static final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        pw.print(solve() ? "YES" : "NO");
        pw.close();
    }
}