package swea;

/**
 * 2021-02-03
 * SWEA 2805 - 농작물 수확하기
 * Memory: 20,948KB
 * Execution Time: 145ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(in.readLine());
        for(int i = 0; i < t; i++) {
        	int sum = 0;
        	int n = Integer.parseInt(in.readLine());
        	int[][] arr = new int[n][n];
        	
        	for(int j = 0; j < n; j++) {
        		String line = in.readLine();
        		for(int k = 0; k < n; k++) {
        			arr[j][k] = line.charAt(k) - '0';
        		}
        	}
        	
        	int start, end, gap = 0;
        	for(int j = 0; j < n; j++) {			//row
        		start = n/2 + (-1) * gap;
        		end = n/2 + gap;
        		
        		for(int k = start; k <= end; k++)	//column
        			sum += arr[j][k];
        		
        		gap += j < n/2 ? 1 : -1; 
        	}
        	sb.append("#").append(i+1).append(" ").append(sum).append("\n");
        }
        
        out.write(sb.toString());
        out.close();
        in.close();
	}
}