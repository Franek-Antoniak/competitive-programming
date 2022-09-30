package bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;


/**
 * Topic: Simulation
 * <p>
 * USACO 2018 December Contest, Bronze
 * <p>
 * Problem 2. The Bucket List
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=856">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/simulation?lang=java">Topic</a>
 */

public class TheBucketList {
    static final class Cow {
        private final int from;
        private final int to;
        private final int buckets;

        Cow(int from, int to, int buckets) {
            this.from = from;
            this.to = to;
            this.buckets = buckets;
        }
    }

    private static Cow getCow() {
        StringTokenizer st = null;
        try {
            st = new StringTokenizer(r.readLine());
        } catch (IOException ignored) {
        }
        assert st != null;
        return new Cow(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
                Integer.parseInt(st.nextToken()));
    }
    static class BruteForceSolution {

        public void solve() throws IOException {
            int n = Integer.parseInt(r.readLine());
            Cow[] cows = new Cow[n];
            int[] demands = new int[1001];
            IntStream.range(0, n)
                    .forEach((x) -> cows[x] = getCow());
            for (int i = 0; i < n; i++)
                paint(demands, cows[i]);
            pw.println(Arrays.stream(demands)
                    .max()
                    .getAsInt());
        }

        private void paint(int[] demands, Cow cow) {
            for (int i = cow.from; i <= cow.to; i++)
                demands[i] += cow.buckets;
        }
    }

    static class OptimizedSolution {
        public void solve() throws IOException {
            int n = Integer.parseInt(r.readLine());
            Cow[] cows = new Cow[n + 1];
            IntStream.rangeClosed(1, n)
                    .forEach((x) -> cows[x] = getCow());
            int[] start = new int[1001];
            int[] end = new int[1001];
            int maxi = 0, temp = 0;
            for (int i = 1; i <= n; i++) {
                start[cows[i].from] = i;
                end[cows[i].to] = i;
            }
            for (int i = 1; i <= 1000; i++) {
                if (start[i] != 0)
                    temp += cows[start[i]].buckets;
                if (end[i] != 0)
                    temp -= cows[end[i]].buckets;
                maxi = Math.max(temp, maxi);
            }
            pw.print(maxi);
        }
    }

    private static PrintWriter pw;
    private static BufferedReader r;

    private static void initIO() {
        String fileName = "blist";
        try {
            r = new BufferedReader(new FileReader(fileName + ".in"));
            pw = new PrintWriter(fileName + ".out");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        initIO();
        new OptimizedSolution().solve();
        pw.close();
    }
}