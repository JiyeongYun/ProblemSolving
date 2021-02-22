package boj;

/**
 * 2021-02-22
 * BOJ 13300
 * Memory: 12020KB
 * Execution Time: 88ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ13300 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] std = new int[2][7];
        int cnt = 0;
        
        while(0 < N--) {
        	st = new StringTokenizer(in.readLine(), " ");
        	std[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] += 1;
        }
        
        for(int i = 0; i < 2; i++) {
        	for(int j = 1; j < 7; j++) {
        		int n = std[i][j];
        		if(n == 0) continue;
        		
        		cnt += n / K;
        		if(n % K != 0) cnt++;
        		
        	}
        }
        out.write(sb.append(cnt).toString());
        out.close(); in.close();
	}
}
