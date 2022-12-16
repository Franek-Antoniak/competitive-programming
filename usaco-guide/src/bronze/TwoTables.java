package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;


/**
 * Topic: Rectangle Geometry
 * <p>
 * Educational Codeforces Round 112 (Rated for Div. 2)
 * <p>
 * Problem B. Two Tables
 * <p>
 * Problem URL: <a href="https://codeforces.com/problemset/problem/1555/B">Problem</a>
 * <p>
 * Topic URL: <a href="https://usaco.guide/bronze/rect-geo?lang=java">Topic</a>
 */
public class TwoTables {
	private static final PrintWriter pw = new PrintWriter(System.out);
	private static final BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int t = Integer.parseInt(r.readLine());
		while (t-- > 0) solve();
		pw.close();
	}

	private static void solve() throws IOException {
		Triple triple = input();
		Rect rect = triple.x;
		RectInfo rectInfo1 = triple.y;
		RectInfo rectInfo3 = triple.z;
		int demandHeight = rectInfo3.height - Math.max(rect.y1, rectInfo1.height() - rect.y2);
		demandHeight = Math.max(demandHeight, 0);
		int demandWidth = rectInfo3.width - Math.max(rect.x1, rectInfo1.width() - rect.x2);
		demandWidth = Math.max(demandWidth, 0);
		boolean heightSol = false, widthSol = false;
		if (demandHeight <= Math.min(rect.y1, rectInfo1.height() - rect.y2)) {
			heightSol = true;
		}
		if (demandWidth <= Math.min(rect.x1, rectInfo1.width() - rect.x2)) {
			widthSol = true;
		}
		if (heightSol && widthSol) {
			pw.println(Math.min(demandHeight, demandWidth));
		} else if (heightSol) {
			pw.println(demandHeight);
		} else if (widthSol) {
			pw.println(demandWidth);
		} else {
			pw.println(-1);
		}
	}

	private static Triple input() throws IOException {
		StringTokenizer st = new StringTokenizer(r.readLine());
		RectInfo rectInfo1 = new RectInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(r.readLine());
		Rect rect = new Rect(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(r.readLine());
		RectInfo rectInfo3 = new RectInfo(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		return new Triple(rect, rectInfo1, rectInfo3);
	}

	private record RectInfo(int width, int height) {
	}

	private record Triple(Rect x, RectInfo y, RectInfo z) {
	}

	private record Rect(int x1, int y1, int x2, int y2) {
	}
}