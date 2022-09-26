package bronze;

import java.io.*;
import java.util.StringTokenizer;


/**
 * Topic: Simulation
 * <p>
 * USACO 2017 December Contest, Bronze
 * <p>
 * Problem 2. The Bovine Shuffle
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=760">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/simulation?lang=java">Topic</a>
 */
public class TheBovineShuffle {
    private static void solve() throws IOException {
        int n = Integer.parseInt(r.readLine());
        int[] map = new int[n];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < n; i++)
            map[Integer.parseInt(st.nextToken()) - 1] = i;
        String[] ids = r.readLine()
                .split(" ");
        String[] result = new String[ids.length];
        for (int i = 0; i < n; i++)
            result[map[map[map[i]]]] = ids[i];
        for (int i = 0; i < n; i++)
            pw.println(result[i]);
    }

    private static PrintWriter pw;
    private static BufferedReader r;

    private static void initIO() {
        String fileName = "shuffle";
        try {
            r = new BufferedReader(new FileReader(fileName + ".in"));
            pw = new PrintWriter(fileName + ".out");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        initIO();
        solve();
        pw.close();
    }
}