package boj;

/**
 * 2021-03-30
 * BOJ 15649 - N과 M (1)
 * Memory: 20,264KB
 * Execution Time: 176ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15649 {

	static int N, M;
	static int[] input, numbers;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N + 1];
		numbers = new int[M];

		for (int i = 1; i <= N; i++) {
			input[i] = i;
		}

		permutation(0, 0);
		out.write(sb.toString());
		out.close();
		in.close();
	}

	public static void permutation(int cnt, int flag) {

		if (cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			if ((flag & 1 << i) != 0)
				continue;
			numbers[cnt] = input[i];
			permutation(cnt + 1, (flag | 1 << i));

		}

	}
}
