package boj;

/**
 * 2021-03-23
 * BOJ 16288 - Passport Control
 * Memory: 11668KB
 * Execution Time: 76ms 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ16288 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] pp = new int[100];

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int order = Integer.parseInt(st.nextToken());

			boolean isPossible = false;
			for (int j = 0; j < K; j++) {
				if (order > pp[j]) {
					pp[j] = order;
					isPossible = true;
					break;
				}
			}

			if (!isPossible) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		in.close();
	}
}
