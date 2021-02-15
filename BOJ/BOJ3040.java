package boj;

/**
 * 2021-02-15
 * BOJ 3040 - 백설 공주와 일곱 난쟁이
 * Memory: 11540KB
 * Execution Time: 76ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ3040 {

	static final int N = 9;
	static int sum = 0;
	static int[] arr = new int[N];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(in.readLine());
			sum += arr[i];
		}
		
		done: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j && sum - arr[i] - arr[j] == 100) {
					for (int k = 0; k < N; k++) {
						if (k != i && k != j) {
							sb.append(arr[k]).append("\n");
						}
					}
					break done;
				}
			}
		}

		out.write(sb.toString());
		out.close();
		in.close();
	}
}
