package boj;

/**
 * 2021-00-00
 * BOJ 20361 - 일우는 야바위꾼
 * Memory: 37760KB
 * Execution Time: 324ms 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ20361 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine(), " ");	
		int N = Integer.parseInt(st.nextToken());		
		int X = Integer.parseInt(st.nextToken());		
		int K = Integer.parseInt(st.nextToken());		
		
		while(0 < K--) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			X = a == X? b : b == X? a : X;
		}
				
		out.write(sb.append(X).toString());
		out.close(); in.close();
	}
}
