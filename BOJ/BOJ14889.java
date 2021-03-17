/**
 * 2021-03-17
 * BOJ 14889 - 스타트 링크 
 * Memory: 36384KB
 * Execution Time: 212ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BOJ_14889_스타트링크_윤지영 {
	public static int N, answer = Integer.MAX_VALUE;
	public static int[][] input;
	public static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		input = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		// input
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
		out.write(sb.append(answer).toString());
		out.close(); in.close();
	}

	public static void dfs(int v, int depth) {
		if (depth == N / 2) {
			makeTeam();
			return;
		}

		for (int i = v + 1; i <= N; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			dfs(i, depth + 1);
			visited[i] = false;
		}
	}

	public static void makeTeam() {
		int[] a = new int[N / 2 + 1];
		int[] b = new int[N / 2 + 1];
		int aIdx = 1;
		int bIdx = 1;
		for (int i = 1; i <= N; i++) {
			if (visited[i]) {
				a[aIdx++] = i;
			} else {
				b[bIdx++] = i;
			}
		}
		answer = Math.min(answer, Math.abs(getState(a) - getState(b)));
	}

	public static int getState(int[] arr) {
		int result = 0;
		for (int i = 1, n = N / 2; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				result += input[arr[i]][arr[j]];
				result += input[arr[j]][arr[i]];
			}
		}
		return result;
	}
}