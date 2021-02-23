package boj;

/**
 * 2021-02-22
 * BOJ 10163 - 색종이 
 * Memory: 12108KB
 * Execution Time: 84ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ10163 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        	StringBuilder sb = new StringBuilder();
        
        	int[][] map = new int[101][101];
        	int N = Integer.parseInt(in.readLine());
        	int[] counting = new int[N+1];
        
        	for(int i = 1; i <= N; i++) {
        		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		int w = Integer.parseInt(st.nextToken());
        		int h = Integer.parseInt(st.nextToken());
        	
			// 색종이를 상하반전을 했다 가정하여 왼쪽상단이 (0,0)라 계산
			// 넓이만큼 i번째 종이라는 것을 표시
       		 	for(int j = 0; j < w; j++) {
        			for(int k = 0; k < h; k++) {
        				map[x+j][y+k] = i;
        			}
        		} 	
        	}
        	
		// counting
        	for(int i = 0; i < 101; i++) {
        		for(int j = 0; j < 101; j++) {
        			counting[map[i][j]] += 1;
        		}
        	}
        
        	for(int i = 1; i <= N; i++) 
			sb.append(counting[i]).append("\n");
        	
        	out.write(sb.toString());
        	out.close(); in.close();
	}
}
