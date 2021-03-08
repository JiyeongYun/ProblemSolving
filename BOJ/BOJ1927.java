package boj;

/**
 * 2021-03-08
 * BOJ 11279 - 최소 힙
 * Memory: 26484KB
 * Execution Time: 288ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ1927 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Long> pq = new PriorityQueue<>();
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
