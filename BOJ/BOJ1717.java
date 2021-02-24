package boj;

/**
 * 2021-02-25
 * BOJ 1717 - 집합의 표현
 * Memory: 48608KB
 * Execution Time: 364ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1717 {

	static int N, M;
	static int[] parents;

	static void make() {
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;
		return parents[a] = findSet(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);

		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parents = new int[N + 1];

		make();

		while (0 < M--) {
			st = new StringTokenizer(in.readLine(), " ");
			int cond = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (cond == 0) {
				union(a, b);
			} else {
				if (findSet(a) == findSet(b)) {
					sb.append("YES\n");
				} else
					sb.append("NO\n");
			}

		}

		out.write(sb.toString());
		out.close();
		in.close();
	}
}
