package boj;

/**
 * 2021-04-14
 * BOJ 15961 - 회전초밥 
 * Memory: 168,644KB
 * Execution Time: 532ms 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15961 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 접시의 수
		int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		int max, kindCnt;

		int[] sushi = new int[N]; 		// 회전 초밥 벨트에 놓인 초밥 번호를 담을 배열
		int[] visit = new int[d + 1]; 	// 초밥 가지수

		// 스시 정보
		for (int i = 0; i < N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}

		// 쿠폰 번호에 해당하는 스시 추가
		visit[c]++;
		kindCnt = 1;

		// 처음 k개 초밥 가짓수 구하기
		for (int i = 0; i < k; i++) {
			if (visit[sushi[i]] == 0)
				kindCnt++;
			visit[sushi[i]]++;
		}
		max = kindCnt;

		// Sliding Window - 왼쪽 스시 하나 빼고, 오른쪽 스시 하나 더하기
		for (int i = 1; i < N + 1; i++) {
			// 1. 왼쪽 스시 하나 빼기
			visit[sushi[i - 1]] -= 1;

			// 2. 왼쪽 스시가 0이면 해당 스시의 종류는 k개 내에 없으므로 가짓수 하나를 줄인다.
			kindCnt += visit[sushi[i - 1]] == 0 ? -1 : 0;

			// 3. 오른쪽 하나 더하기
			visit[sushi[(i + k - 1) % N]] += 1;

			// 4. 오른쪽 스시가 1이면(기존에 존재하지 않고 3번에서 추가된 스시인 경우) 가짓수 하나를 증가시킨다.
			kindCnt += visit[sushi[(i + k - 1) % N]] == 1 ? 1 : 0;

			// 5. 가짓수 최대값 업데이트
			max = max < kindCnt ? kindCnt : max;
		}

		System.out.println(max);

	}
}