package general;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Topic: Expected Knowledge - Introductory USACO Bronze Problems
 * <p>
 * USACO 2016 January Contest, Bronze
 * <p>
 * Problem 1. Promotion Counting
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=591">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/general/expected-knowledge?lang=java">Topic</a>
 */
public class PromotionCounting {
    record Pair(int f, int s) {
    }

    // My solution
    private static void solve1() throws IOException {
        StringTokenizer s = new StringTokenizer(r.readLine());
        Pair[] pairs = new Pair[4];
        for (int i = 0; i < 4; i++) {
            pairs[i] = new Pair(Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()));
            if (r.ready()) s = new StringTokenizer(r.readLine());
        }
        int newPeople = Arrays.stream(pairs).map(p -> p.s - p.f).reduce(0, Integer::sum);
        Pair[] simulation = new Pair[4];
        simulation[0] = new Pair(pairs[0].f, pairs[0].f + newPeople);
        for (int i = 1; i < 4; i++)
            simulation[i] = new Pair(pairs[i].f, pairs[i].f + (simulation[i - 1].s - pairs[i - 1].s));
        for(int i = 1; i < 4; i++) {
            pw.println(simulation[i].s - simulation[i].f);
        }
    }

    // The best Solution
    private static void solve2() throws IOException {
        Pair[] pairs = new Pair[4];
        StringTokenizer s = new StringTokenizer(r.readLine());
        for (int i = 0; i < 4; i++) {
            pairs[i] = new Pair(Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken()));
            if (r.ready()) s = new StringTokenizer(r.readLine());
        }
        pw.println(pairs[1].s - pairs[1].f + pairs[2].s - pairs[2].f + pairs[3].s - pairs[3].f);
        pw.println(pairs[2].s - pairs[2].f + pairs[3].s - pairs[3].f);
        pw.println(pairs[3].s - pairs[3].f);
    }

    private static final PrintWriter pw;
    private static final BufferedReader r;


    static {
        try {
            pw = new PrintWriter("promote.out");
            r = new BufferedReader(new FileReader("promote.in"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        solve2();
        pw.close();
    }
}

