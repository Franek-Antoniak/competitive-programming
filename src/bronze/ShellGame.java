package bronze;

import java.io.*;
import java.util.Arrays;


/**
 * Topic: Simulation
 * <p>
 * USACO 2019 January Contest, Bronze
 * <p>
 * Problem 1. Shell Game
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=891">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/simulation?lang=java">Topic</a>
 */
public class ShellGame {
    private static void solve() throws IOException {
        int n = Integer.parseInt(r.readLine());
        int[] tab = {0, 1, 2};
        int[] result = {0, 0, 0};
        for (int i = 0; i < n; i++) {
            int[] temp = Arrays.stream(r.readLine()
                            .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            swap(tab, temp[0] - 1, temp[1] - 1);
            result[tab[temp[2] - 1]]++;
        }
        pw.println(Arrays.stream(result).max().getAsInt());
    }

    private static void swap(int[] tab, int i, int j) {
        int temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
    }

    private static final PrintWriter pw;
    private static final BufferedReader r;

    static {
        try {
            r = new BufferedReader(new FileReader("shell.in"));
            pw = new PrintWriter("shell.out");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        solve();
        pw.close();
    }
}