package boj;

/**
 * 2021-04-01
 * BOJ 2667 - 단지번호붙이기
 * Memory: 11,636KB
 * Execution Time: 76ms 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ2667 {
	
	static int N, numOfHouse;
	static int[] house;
	static int[][] map;
	static boolean[][] isVisited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		// input N && initialize
		N = Integer.parseInt(in.readLine());
		house = new int[625];	// max size of map (if n is 25)
		map = new int[N][N];
		isVisited = new boolean[N][N];
		numOfHouse = 0;
		// input map
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < N; j++) {
				int n= line.charAt(j)-'0' ;
				map[i][j] = n;
			}
		}
		
		// search
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !isVisited[i][j]) {
					numOfHouse++;
					dfs(i, j);
				}
			}
		}
	
		// sort
		Arrays.sort(house);
		
		// print
		sb.append(numOfHouse).append("\n");
		for(int i = house.length-numOfHouse; i < house.length; i++) {
				sb.append(house[i]).append("\n");	
		}
		
		out.write(sb.toString());
		out.close(); in.close();
		
	}

	private static void dfs(int i, int j) {
		isVisited[i][j] = true;
		house[numOfHouse]++;
		
		for(int d = 0; d < 4; d++) {
			int nx = i + dx[d];
			int ny = j + dy[d];
			
			if(0 <= nx && 0 <= ny && nx < N && ny < N) {
				if(map[nx][ny] == 1 && !isVisited[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
		
	}

}
