package bronze;

import java.io.*;
import java.util.StringTokenizer;


/**
 * Topic: Rectangle Geometry
 * <p>
 * USACO 2017 December Contest, Bronze
 * <p>
 * Problem 1. Blocked Billboard
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=759">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/rect-geo?lang=java">Topic</a>
 */
public class BlockedBillboard {
    record Point(int x, int y) {
    }

    private static void solve() throws IOException {
        Point[][] billboard = new Point[3][2];
        int result = 0;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            billboard[i] = new Point[2];
            for (int j = 0; j < 2; j++) {
                billboard[i][j] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
        }
        for (int i = 0; i < 2; i++) {
            int firstInterLenX = Math.max(Math.min(billboard[2][1].x, billboard[i][1].x) - Math.max(billboard[2][0].x,
                    billboard[i][0].x), 0);
            int firstInterLenY = Math.max(Math.min(billboard[2][1].y, billboard[i][1].y) - Math.max(billboard[2][0].y,
                    billboard[i][0].y), 0);
            result += ((billboard[i][1].x - billboard[i][0].x) * (billboard[i][1].y - billboard[i][0].y)) - firstInterLenX * firstInterLenY;
        }
        pw.print(result);
    }

    private static final PrintWriter pw;
    private static final BufferedReader r;

    static {
        try {
            r = new BufferedReader(new FileReader("billboard.in"));
            pw = new PrintWriter("billboard.out");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        solve();
        pw.close();
    }
}