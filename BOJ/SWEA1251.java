package swea;

/**
 * 2021-03-24
 * SWEA 1251 - [S/W 문제해결 응용] 4일차 - 하나로 
 * Memory: 48,264KB
 * Execution Time: 216ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1251 {

	static int T, N;
	static double E;
	static double[] minEdge;
	static boolean[] visited;

	static int[][] points;
	static double[][] adjMatrix;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			minEdge = new double[N];
			points = new int[N][2];
			adjMatrix = new double[N][N];
			visited = new boolean[N];

			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				points[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				points[i][1] = Integer.parseInt(st.nextToken());
			}
			Arrays.fill(minEdge, Long.MAX_VALUE);
			E = Double.parseDouble(in.readLine());

			// 두 점 사이에 해저터널을 건설하는 경우 발생하는 비용: E * L2 = E * sqrt((x1-x2)^2 + (y1-y2)^2)
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <= i; j++) { // 섬1 -> 섬2나 섬2 -> 섬1의 비용은 동일하기 때문에 대칭 구조
					int dx = points[i][0] - points[j][0];
					int dy = points[i][1] - points[j][1];

					double cost = (double) (E * (Math.pow(dx, 2) + Math.pow(dy, 2)));
					adjMatrix[i][j] = adjMatrix[j][i] = cost;

				}
			}

			double result = 0;
			minEdge[0] = 0;

			for (int i = 0; i < N; i++) {
				double min = (double) Long.MAX_VALUE;
				int minVertex = 0; 
				for (int j = 0; j < N; j++) {
					if (!visited[j] && min > minEdge[j]) {
						min = minEdge[j];
						minVertex = j;
					}
				}

				result += min;
				visited[minVertex] = true;
				for (int j = 0; j < N; j++) {
					if (!visited[j] && minEdge[j] > adjMatrix[minVertex][j]) {
						minEdge[j] = adjMatrix[minVertex][j];
					}
				}
			}
			sb.append("#").append(t).append(" ").append(Math.round(result)).append("\n");
		}

		out.write(sb.toString());
		out.close();
		in.close();
	}
}
