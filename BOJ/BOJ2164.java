package boj;

/**
 * 2021-03-02
 * BOJ 2164 - 카드2
 * Memory: 43420KB
 * Execution Time: 144ms 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
 		int T = Integer.parseInt(in.readLine());
		
		for(int i = 1; i <= T; i++) {
			q.add(i);
		}
		
		while(!q.isEmpty()) {
			if(q.size() == 1) {
				sb.append(q.peek());
				break;
			}
			
			q.poll();
			q.add(q.poll());	
		}
		out.write(sb.toString());
		out.close();
		in.close();
	}
}
