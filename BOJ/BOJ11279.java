package boj;

/**
 * 2021-03-15
 * BOJ 11279 - 최대 힙
 * Memory: 26452KB
 * Execution Time: 300ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ11279 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
		int T = Integer.parseInt(in.readLine());
		
		while(0 < T--) {
			int n = Integer.parseInt(in.readLine());
			if(n == 0) {
				if(pq.isEmpty()) sb.append("0\n");
				else sb.append(pq.poll()).append("\n");
			}else {
				pq.offer((long)n);
			}
			
		}
		
		out.write(sb.toString());
		out.close();
		in.close();
	}
}
