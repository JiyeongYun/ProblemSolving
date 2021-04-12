package boj;

/**
 * 2021-04-12
 * BOJ 11047 - 동전0
 * Memory: 11,544KB
 * Execution Time: 80ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(in.readLine());
		}

		int cnt = 0;
		for (int i = N - 1; 0 <= i; i--) {
			cnt += K / coins[i];
			K = K % coins[i];
		}

		System.out.println(cnt);
		in.close();
	}
}
