package boj;

/**
 * 2021-04-14
 * BOJ 7576 - 토마토 
 * Memory: 139,528KB
 * Execution Time: 596ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
	int r; // 행
	int c; // 열
	int t; // 시간

	public Tomato(int r, int c, int t) {
		this.r = r;
		this.c = c;
		this.t = t;
	}
}

public class BOJ7576 {

	static int N, M, max = 0;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	static List<Tomato> tomatos;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(in.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		tomatos = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1)
					tomatos.add(new Tomato(i, j, 0));
				map[i][j] = n;
			}
		}

		bfs();

		// 모든 토마토가 익었는지 체크
		boolean isPossible = true;
		loop: for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					isPossible = false;
					break loop;
				}
			}
		}
		if (isPossible) {
			System.out.println(max);
		} else
			System.out.println(-1);

		in.close();
	}

	private static void bfs() {
		Queue<Tomato> q = new LinkedList<>();

		for (Tomato t : tomatos) {
			q.add(new Tomato(t.r, t.c, t.t));
			visited[t.r][t.c] = true;
		}

		while (!q.isEmpty()) {
			Tomato tomato = q.poll();

			int r = tomato.r;
			int c = tomato.c;
			int t = tomato.t;

			max = max < t ? t : max;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])
					continue;

				if (map[nr][nc] != -1) {
					map[nr][nc] = 1;
					visited[nr][nc] = true;
					q.add(new Tomato(nr, nc, t + 1));
				}

			}

		}

	}
}
