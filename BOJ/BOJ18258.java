package boj;

/**
 * 2021-03-04
 * BOJ 18258 - 큐2
 * Memory: 324632KB 
 * Execution Time: 1208ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ18258 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Deque<Integer> stack = new ArrayDeque<>();
		
		int N = Integer.parseInt(in.readLine());
		while(0 < N--) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			String command = st.nextToken();
			
			if(command.equals("push")) {
				stack.add(Integer.parseInt(st.nextToken()));
			} else if(command.equals("size")) {
				sb.append(stack.size()).append("\n");
			} else if(command.equals("empty")) {
				
				if(stack.size() == 0) {
					sb.append("1\n");	// empty
				} else {
					sb.append("0\n");	// not empty
				}
				
			} else {
				
				if(stack.size() == 0) {
					sb.append("-1\n");
				} else {
					if(command.equals("pop")) {
						sb.append(stack.pop()).append("\n");
					} else if(command.equals("front")) {
						sb.append(stack.peek()).append("\n");
					} else if(command.equals("back")) {
						sb.append(stack.peekLast()).append("\n");
					}
				}
			}			
		}

		out.write(sb.toString());
		out.close();
		in.close();
	}
}
