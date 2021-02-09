package boj;

/**
 * 2021-02-09
 * BOJ 2563 - 색종이 
 * Memory: 11624KB
 * Execution Time: 80ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2563 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int area = 0;
        boolean[][] paper = new boolean[100][100];
        
        int N = Integer.parseInt(in.readLine());
        
        while(0 < N--){
        	StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        	int x = Integer.parseInt(st.nextToken());
        	int y = Integer.parseInt(st.nextToken());
        	
        	int nx, ny;
        	for(int i = 0; i < 10; i++) {
        		nx = x + i;
        		for(int j = 0; j < 10; j++) {
            		ny = y + j;
            		
        			if(paper[nx][ny]) continue;
        			
        			area++;
        			paper[nx][ny] = true;
        			
        			
        		}
        	}
        	
        	
        }
        out.write(sb.append(area).toString());
        out.close(); in.close();
	}
}
