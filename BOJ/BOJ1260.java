package boj;

/**
 * 2021-03-16
 * BOJ 1260 - DFS와 BFS
 * Memory: 18404KB
 * Execution Time: 212ms 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {

	static int N, M, V;
	static boolean[] visited;
	static boolean[][] adjMatrix;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adjMatrix = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[from][to] = adjMatrix[to][from] = true;
		}
		
		visited = new boolean[N+1];
		dfs(V);
		
		sb.append("\n");
		bfs();

		out.write(sb.toString());
		out.close();
		in.close();
	}

	
	private static void dfs(int V) {
		visited[V] = true;
		sb.append(V + " ");
		
		for(int i = 1; i < N+1; i++) {
			if(adjMatrix[V][i] && !visited[i]) {
				dfs(i);
			}
		}
		
	}
	
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		q.offer(V);
		visited[V] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			sb.append(current + " ");
			
			for(int i = 1; i < N+1; i++) {
				if(adjMatrix[current][i] && !visited[i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}	
	}
}
