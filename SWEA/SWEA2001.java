package swea;

/**
 * 2021-02-03
 * SWEA 2001 - 파리 퇴치
 * Memory: 18,280KB
 * Execution Time: 110ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA2001 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(in.readLine());
        for(int i = 0; i < t; i++) {
        	StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        	int n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	int[][] arr = new int[n][n];
        	
        	
        	// 배열에 값 넣기 
        	for(int j = 0; j < n; j++) {
        		st = new StringTokenizer(in.readLine(), " ");
        		for(int k = 0; k < n; k++) {
        			arr[j][k] = Integer.parseInt(st.nextToken());
        		}
        	}
        	
        	// 탐색
        	int max = 0;
        	for(int j = 0; j <= n-m; j++) {
        		for(int k = 0; k <= n-m; k++) {
        			int sum = 0;
        			for(int x = 0; x < m; x++) {
        				for(int y = 0; y < m; y++) {
        					sum += arr[j+x][k+y];
        					max = sum > max? sum : max;
        				}
        			}
        			
        		}
        	}
        	sb.append("#").append(i+1).append(" ").append(max).append("\n");
        }
        
        out.write(sb.toString());
        out.close();
        in.close();

	}

}
