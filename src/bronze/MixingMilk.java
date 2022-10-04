package bronze;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * Topic: Simulation
 * <p>
 * USACO 2018 December Contest, Bronze
 * <p>
 * Problem 1. Mixing Milk
 * <p>
 * Problem URL: <a href="http://www.usaco.org/index.php?page=viewproblem2&cpid=855">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/simulation?lang=java">Topic</a>
 */
public class MixingMilk {

	private static final PrintWriter pw;
	private static final BufferedReader r;

	static {
		try {
			r = new BufferedReader(new FileReader("mixmilk.in"));
			pw = new PrintWriter("mixmilk.out");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) throws IOException {
		solve();
		pw.close();
	}

	private static void solve() throws IOException {
		Bucket[] buckets = new Bucket[3];
		for (int i = 0; i < 3; i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(r.readLine());
			buckets[i] = new Bucket(Integer.parseInt(stringTokenizer.nextToken()),
					Integer.parseInt(stringTokenizer.nextToken()));
		}
		simulate(buckets);
		Arrays.stream(buckets)
		      .map(x -> x.milk)
		      .forEach(pw::println);
	}

	private static void simulate(Bucket[] buckets) {
		for (int i = 0; i < 100; i++) {
			transfer(buckets[i % 3], buckets[(i + 1) % 3]);
		}
	}

	private static void transfer(Bucket bucket1, Bucket bucket2) {
		int transfer = Math.min(bucket1.milk, bucket2.capacity - bucket2.milk);
		bucket2.milk += transfer;
		bucket1.milk -= transfer;
	}

	static final class Bucket {
		int capacity;
		int milk;

		Bucket(int capacity, int milk) {
			this.capacity = capacity;
			this.milk = milk;
		}
	}
}