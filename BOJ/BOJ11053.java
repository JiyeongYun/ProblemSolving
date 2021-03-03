package boj;

/**
 * 2021-03-03
 * BOJ 11053 - 가장 긴 증가하는 부분 수열
 * Memory: 12408KB
 * Execution Time: 108ms 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];

		// input
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int max = 0;
		
		// arr을 하나씩 순회 
		for (int i = 0; i < N; i++) {
			// 일단 가장 긴 수열이 자기 자신 뿐이라 가정하여 1로 초기
			dp[i] = 1;
			// 자기보다 앞에 있는 값들을 하나씩 순회
			for (int j = 0; j < i; j++) {
				// 만약 자기보다 작은 값들 중 순열이 가장 길게 만들어진 (dp배열 참고하여 값 가져오기) 값 + 1과 비교
				// +1을 하는 이유는 자기자신까지 포함되었을 때 길이가 하나 증가하기 때문
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			
			max = max < dp[i] ? dp[i] : max;
		}

		out.write(sb.append(max).toString());
		out.close();
		in.close();
	}
}
