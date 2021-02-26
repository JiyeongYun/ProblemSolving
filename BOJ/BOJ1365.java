package boj;

/**
 * 2021-02-26
 * BOJ 1365 - 꼬인 전깃줄
 * Memory: 25900KB
 * Execution Time: 276ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1365 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int[] LIS = new int[N];

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int size = 0;
		for (int i = 0; i < N; i++) {
			int temp = Arrays.binarySearch(LIS, 0, size, arr[i]);
			if (temp < 0)
				temp = Math.abs(temp) - 1;
			LIS[temp] = arr[i];
			if (temp == size)
				++size;
		}

		System.out.println(N - size);
		in.close();
	}
}
