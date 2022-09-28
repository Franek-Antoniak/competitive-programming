package bronze;

import java.io.*;
import java.util.StringTokenizer;


/**
 * Topic: Simulation
 * <p>
 * USACO 2019 February Contest, Bronze
 * <p>
 * Problem 3. Measuring Traffic
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=917">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/simulation?lang=java">Topic</a>
 */
public class MeasuringTraffic {
    private static int[] getIntersect(int[] first, int[] second) {
        int x = Math.max(first[0], second[0]);
        int y = Math.min(first[1], second[1]);
        return new int[]{x, y};
    }

    static final class Sensor {
        private final String what;
        private final int[] pair;

        Sensor(String what, int[] pair) {
            this.what = what;
            this.pair = pair;
        }
    }

    private static int[] solve(Sensor[] sensors, boolean b) {
        int[] result = new int[]{0, 1_000_001};
        for (int i = 0; i < sensors.length; i++) {
            int q = b ? i : sensors.length - i - 1;
            if (sensors[q].what.equals("on") && b || sensors[q].what.equals("off") && !b) {
                    result[0] += sensors[q].pair[0];
                    result[1] += sensors[q].pair[1];
            } else if (sensors[q].what.equals("on") && !b || sensors[q].what.equals("off") && b) {
                    result[0] = Math.max(result[0] - sensors[q].pair[1], 0);
                    result[1] -= sensors[q].pair[0];
            } else {
                result = getIntersect(result, sensors[q].pair);
            }
        }
        return result;
    }

    private static void solve() throws IOException {
        int n = Integer.parseInt(r.readLine());
        Sensor[] sensors = new Sensor[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            String what = st.nextToken();
            int[] pair = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            sensors[i] = new Sensor(what, pair);
        }
        int[] result1 = solve(sensors, false);
        int[] result2 = solve(sensors, true);
        pw.println(result1[0] + " " + result1[1]);
        pw.println(result2[0] + " " + result2[1]);
    }

    private static PrintWriter pw;
    private static BufferedReader r;

    private static void initIO() {
        String fileName = "traffic";
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