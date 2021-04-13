package boj;

/**
 * 2021-04-13
 * BOJ 14716 - 현수막   
 * Memory: 21,976KB
 * Execution Time: 232ms
 * Link: https://www.acmicpc.net/problem/14716
 * 
 * 
 ***** POINT *****
 1. visited 배열 대신 map에서 0, 1로 방문처리
 2. java.awt.Point 사용   
 *****************
 */



import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14716 {

	static int N, M; // (1 ≤ M,N ≤ 250) 문제에서는 N과 M을 반대로 제시
	static int[][] map;
	static int[] dr = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int[] dc = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static Queue<Point> q;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		q = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					answer++;
					q.add(new Point(i, j));
					bfs();
				}
			}
		}

		System.out.println(answer);
		in.close();
	}

	private static void bfs() {

		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int d = 0; d < 8; d++) {
				int nr = p.x + dr[d];
				int nc = p.y + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == 0)
					continue;
				
				map[nr][nc] = 0;
				q.add(new Point(nr, nc));
			}

		}

	}
}
