package general;

import java.util.Scanner;


/**
 * Topic: Introduction to Competitive Programming
 * <p>
 * Problem: Basketball One-on-One
 * <p>
 * Problem URL: <a href="https://open.kattis.com/problems/basketballoneonone">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/general/intro-cp?lang=java">Topic</a>
 */
public class BasketBallOneOnOne {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String x = input.next();
		System.out.println(x.charAt(x.length() - 2));
	}
}