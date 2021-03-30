package boj;

/**
 * 2021-03-30
 * BOJ 11399 - ATM
 * Memory: 11,840KB
 * Execution Time: 88ms 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			// 방법1
			cnt += arr[i];
			sum += cnt;
			// 방법2
//			sum += arr[i] * (N-i);
		}
		System.out.println(sum);
		in.close();
	}
}
