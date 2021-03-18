package jungol;

/**
 * 2021-03-18
 * JUNGOL 1863 - 종교 
 * Memory: 29MB
 * Execution Time: 533ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1863 {

	static int N, M;
	static int[] parents;
	static boolean[] check;

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
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N + 1];
		check = new boolean[N + 1];

		make();

		int count = 0;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			union(a, b);

		}

		for (int i = 1; i <= N; i++) {
			if (i == parents[i])
				count++;
		}

		System.out.println(count);
		in.close();
	}
}
