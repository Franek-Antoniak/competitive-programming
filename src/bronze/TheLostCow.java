package bronze;

import java.io.*;
import java.util.StringTokenizer;


/**
 * Topic: Simulation
 * <p>
 * USACO 2017 US Open Contest, Bronze
 * <p>
 * Problem 1. The Lost Cow
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=735">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/simulation?lang=java#problem-usaco-735">Topic</a>
 */
public class TheLostCow {

    public static int log2(int val) {
        return 31 - Integer.numberOfLeadingZeros(val);
    }

    private static int solve() throws IOException {
        StringTokenizer st = new StringTokenizer(r.readLine());
        int x = Integer.parseInt(st.nextToken()),
                y = Integer.parseInt(st.nextToken());
        int len = Math.abs(x - y);
        int log2 = log2(len);
        int how_many_steps = (1 << log2) == len ? log2 : log2 + 1;
        int result = 3 * (1 << how_many_steps);
        int result1 = (result - 2) - ((result / 3) - len);
        int result2 = (result - 2) + ((result / 3) + len);
        if (how_many_steps % 2 == 0)
            return y > x ? result1 : result2;
        return y < x ? result1 : result2;
    }

    private static final PrintWriter pw;
    private static final BufferedReader r;

    static {
        try {
            r = new BufferedReader(new FileReader("lostcow.in"));
            pw = new PrintWriter("lostcow.out");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        pw.print(solve());
        pw.close();
    }
}