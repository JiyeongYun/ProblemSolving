package boj;

/**
 * 2021-03-04
 * BOJ 11054 - 가장 긴 바이토닉 부분 수열 
 * Memory: 12784KB
 * Execution Time: 116ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ11054 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int[] DP = new int[N];
		int[] rDP = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// order
		for (int i = 0; i < N; i++) {
			DP[i] = 1;

			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					DP[i] = Math.max(DP[i], DP[j] + 1);
				}
			}
		}

		// reverse order
		for (int i = N - 1; 0 <= i; i--) {
			rDP[i] = 1;

			for (int j = N - 1; i < j; j--) {
				if (arr[j] < arr[i]) {
					rDP[i] = Math.max(rDP[i], rDP[j] + 1);
				}
			}
		}

		
		int max = DP[0] + rDP[0];
		for (int i = 1; i < N; i++) {
			max = Math.max(max, DP[i] + rDP[i]);
		}

		// max-1을 하는 이유: 자기자신이 2번 포함되기 때문에
		out.write(sb.append(max - 1).toString());
		out.close();
		in.close();
	}
}
