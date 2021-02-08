package swea;

/**
 * 2021-02-08
 * SWEA 9229 - 한빈이와 Spot Mart
 * Memory: 30,016KB
 * Execution Time: 175ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA9229 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(in.readLine());
        for(int i = 1; i <= T; i++) {

        	// Input N, M
        	st = new StringTokenizer(in.readLine(), " ");
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	int[] weights = new int[N];
        	
        	// Input weight of N bags of cookies
        	st = new StringTokenizer(in.readLine(), " ");
        	for(int j = 0; j < N; j++) {
        		weights[j] = Integer.parseInt(st.nextToken());
        	}
        	
        	int max = 0;
        	for(int j = 0; j < N; j++) {
        		for(int k = j+1; k < N; k++) {
        			int sum = weights[j] + weights[k];
        			if(sum <= M) {
        				max = max < sum ? sum : max;
        			}
        		}
        		
        	}
        	
        	sb.append("#").append(i).append(" ").append(max == 0 ? -1 : max).append("\n");

        }
        out.write(sb.toString());
        out.close(); in.close();
	}
}



