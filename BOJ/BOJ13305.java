package boj;


/**
 * 2021-06-07
 * BOJ 13305 - 주유소
 * Memory: 41,448KB
 * Execution Time: 372ms 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13305{
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(in.readLine());
		long[] dists = new long[N - 1];
		long[] prices = new long[N];	
		long sum = 0;

		// 거리값 입력받기
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N - 1; i++) {
			dists[i] = Long.parseLong(st.nextToken());
		}
		// 각 마을별 주유비 입력받기
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			prices[i] = Long.parseLong(st.nextToken());
		}

		long minPrice = prices[0];
		for (int i = 0; i < N - 1; i++) {
			if (prices[i] < minPrice) minPrice = prices[i];
			sum += minPrice * dists[i];
		}
		System.out.println(sum);
		in.close();
	}
}
