package boj;

/**
 * 2021-02-18
 * BOJ 1987 - 알파벳
 * Memory: 12484KB
 * Execution Time: 932ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1987 {

	static int R, C, maxCnt = Integer.MIN_VALUE;;
	static int[][] map;
	static int[][] dir = {{0, 0, 1, -1},{1, -1, 0, 0}};
	static boolean[] visited = new boolean[26];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			String temp = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j) - 'A';
			}
		}
		
		visited[map[0][0]] = true;
		dfs(0, 0, 1);

		out.write(sb.append(maxCnt).toString());
		out.close();
		in.close();
	}

	private static void dfs(int x, int y, int count) {
		maxCnt = maxCnt < count ? count : maxCnt;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dir[0][i];
			int ny = y + dir[1][i];

			if (0 <= nx && nx < R && 0 <= ny && ny < C) {
				int num = map[nx][ny];
				if (!visited[num]) {
					visited[num] = true;
					dfs(nx, ny, count + 1);
					visited[num] = false;
				}
			}
		}
	}

}
