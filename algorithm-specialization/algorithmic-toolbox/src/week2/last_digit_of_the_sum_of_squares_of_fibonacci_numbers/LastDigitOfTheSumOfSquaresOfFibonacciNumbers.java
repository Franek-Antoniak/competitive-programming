package week2.last_digit_of_the_sum_of_squares_of_fibonacci_numbers;

import java.io.*;
import java.util.InputMismatchException;

public class LastDigitOfTheSumOfSquaresOfFibonacciNumbers {

	public static void main(String[] args) {
		Solution.solve();
	}
}

class Solution {
	static void solve() {
		try (FastIO io = new FastIO()) {
			long n = io.nextLong();
			io.println(getSquaredFibonacciNumberSumLastDigit(n));
		}
	}

	// to calculate it we can also use the formula
	// S(n) = F(n+2) - 1
	static long getSquaredFibonacciNumberSumLastDigit(long n) {
		int pisanoperiod = 60, M = 10;
		n = (int) (n % pisanoperiod);
		if (n <= 1) {
			return n;
		}
		long sum = 1;
		long first = 0;
		long second = 1;
		for (long i = 1; i < n; i++) {
			long temp = (first + second) % M;
			first = second;
			second = temp;
			sum = (sum + (second * second)) % M;
		}
		return sum;
	}
}


class FastIO extends PrintWriter {
	private final InputStream stream;
	private final byte[] buf = new byte[1 << 16];
	private int curChar;
	private int numChars;

	// standard input
	public FastIO() {
		this(System.in, System.out);
	}

	public FastIO(InputStream i, OutputStream o) {
		super(o);
		stream = i;
	}

	// file input
	public FastIO(String i, String o) throws IOException {
		super(new FileWriter(o));
		stream = new FileInputStream(i);
	}

	public int nextInt() {  // nextLong() would be implemented similarly
		int c;
		do {
			c = nextByte();
		} while (c <= ' ');

		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = nextByte();
		}

		int res = 0;
		do {
			if (c < '0' || c > '9') {
				throw new InputMismatchException();
			}
			res = 10 * res + c - '0';
			c = nextByte();
		} while (c > ' ');
		return res * sgn;
	}

	// throws InputMismatchException() if previously detected end of file
	private int nextByte() {
		if (numChars == -1) {
			throw new InputMismatchException();
		}
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = stream.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars == -1) {
				return -1;  // end of file
			}
		}
		return buf[curChar++];
	}

	public long nextLong() {
		int c;
		do {
			c = nextByte();
		} while (c <= ' ');

		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = nextByte();
		}

		long res = 0;
		do {
			if (c < '0' || c > '9') {
				throw new InputMismatchException();
			}
			res = 10 * res + c - '0';
			c = nextByte();
		} while (c > ' ');
		return res * sgn;
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}

	// to read in entire lines, replace c <= ' '
	// with a function that checks whether c is a line break
	public String next() {
		int c;
		do {
			c = nextByte();
		} while (c <= ' ');

		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = nextByte();
		} while (c > ' ');
		return res.toString();
	}
}