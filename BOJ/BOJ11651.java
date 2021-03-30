package boj;

/**
 * 2021-03-30
 * BOJ 11651 - 좌표 정렬하기2
 * Memory: 61,440KB
 * Execution Time: 636ms 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11651 {

	static class Point implements Comparable<Point> {
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point o) {
			if (this.y == o.y)
				return this.x - o.x;
			return this.y - o.y;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		List<Point> p = new ArrayList<>();
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			p.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(p);
		for (int i = 0; i < N; i++) {
			sb.append(p.get(i).x).append(" ").append(p.get(i).y).append("\n");
		}
		out.write(sb.toString());
		out.close();
		in.close();
	}
}
