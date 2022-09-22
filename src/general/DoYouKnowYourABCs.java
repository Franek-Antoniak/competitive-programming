package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * Topic: Expected Knowledge - Introductory USACO Bronze Problems
 * <p>
 * USACO 2020 December Contest, Bronze
 * <p>
 * Problem 1. Do You Know Your ABCs?
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=1059">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/general/expected-knowledge?lang=java">Topic</a>
 */
public class DoYouKnowYourABCs {

    private static void solve() throws IOException {
        int[] nums = new int[7];
        StringTokenizer st = new StringTokenizer(r.readLine());
        for (int i = 0; i < 7; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        pw.print(nums[0] + " " + nums[1] + " ");
        if(nums[0] + nums[1] == nums[2])
            pw.print(nums[3]);
        else
            pw.println(nums[2]);
    }

    private static final PrintWriter pw = new PrintWriter(System.out);
    private static final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        solve();
        pw.close();
    }
}