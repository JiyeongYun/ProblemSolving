package boj;

/**
 * 2021-03-08
 * BOJ 14503 - 로봇 청소기 
 * Memory: 11920KB
 * Execution Time: 92ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ14503 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 방향 북(0),동(1),남(2),서(3) 순서대로

		st = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(st.nextToken()); // 로봇 위치의 x좌표
		int c = Integer.parseInt(st.nextToken()); // 로봇 위치의 y좌표
		int d = Integer.parseInt(st.nextToken()); // 로봇이 바라보고 있는 방향

		// 청소 상태 input 받기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;

//		map[i][j] 값이 0이면 청소 하지 않은 공간, -1이면 청소한 공간, 1이면 벽
//		CASE 1. 현재 위치를 청소한다.
		map[r][c] = -1;
		cnt++;

//		CASE 2. 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
//			CASE a. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
//			CASE b. 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
//				a,b => 왼쪽 방향에서 아직 청소하지 않은 공간이 나타날 때까지 왼쪽으로 TURN
//			CASE c. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
//			CASE d. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.

		while (true) {

			// 2-a,b 왼쪽방향 Check
			// 상,하,좌,우 네 방향 중 청소할 공간이 하나라도 있으면 isPossible = true
			// 그렇지 않으면 isPossible = false
			boolean isPossible = false;
			for (int i = 0; i < 4; i++) {
				d += (d == 0) ? 3 : -1;
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];

				if (map[nr][nc] == 0) {
					r = nr;
					c = nc;
					isPossible = true;
					break;
				}
			}

			if (isPossible) { // 왼쪽으로 turn 하면서 청소할 곳이 있는 경우
				// 이동하고 count 증가
				map[r][c] = -1;
				cnt++;
			} else { // 현재위치 상,하,좌,우 모두 청소가 되어있거나 벽인 경우

				// d: 0 <-> 2, 1 <-> 3
				// 바라보는 방향을 유지한 채로 후진하기 때문에 이동하는 데에 사용되는 방향변수를 새로 만듦
				int nd = (1 < d) ? d - 2 : d + 2;
				r += dir[nd][0];
				c += dir[nd][1];

				// CASE d: 후진하려는 곳이 벽이라 이동이 불가한 경우 -> 종료
				if (map[r][c] == 1) {
					break;
				}

			}

		}

		out.write(sb.append(cnt).toString());
		out.close();
		in.close();
	}
}
