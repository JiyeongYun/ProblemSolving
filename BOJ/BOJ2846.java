package boj;

/**
 * 2021-05-01
 * BOJ 2846 - 오르막길 
 * https://www.acmicpc.net/problem/2846
 * Memory: 11760KB
 * Execution Time: 84ms 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2846 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int before, gap = 0, min = 0;

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		before = Integer.parseInt(st.nextToken());
		min = before;
		for (int i = 1; i < N; i++) {
			int now = Integer.parseInt(st.nextToken());
			if (before < now)
				gap = Math.max(gap, now - min);
			else
				min = now;
			before = now;
		}

		System.out.println(gap);

		in.close();
	}
}
