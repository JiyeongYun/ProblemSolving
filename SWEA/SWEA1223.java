package swea;

/**
 * 2021-02-05
 * SWEA 1223 - 계산기2
 * Memory: 18,652KB
 * Execution Time: 102ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class SWEA1223 {
	
	static final int T = 10;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= T; i++) {
			String exp = "";
			Stack<Character> op = new Stack<>();
			Stack<Integer> answer = new Stack<>();
			
			// Convert expression to postfix operator
			int len = Integer.parseInt(in.readLine());
			String str = in.readLine();
			for(int j = 0; j < len; j++) {
				char c = str.charAt(j);
				
				// string은 0~9, +, *로 구성되어 있기 때문에 48이상은 숫자라는 의미
				if(48 <= c) {		
					exp += c;
				}else {
					if(c == '*' || op.empty()) {			
						op.add(c);
					}else if(c == '+'){			 
						while(!op.empty()) {	
							exp += op.pop();
						}
						op.add(c);
					}
				}
			}
			
			// Add remaining operator in stack
			while(!op.empty()) 
				exp += op.pop();
			
			// Calculate
			for(int j = 0; j < exp.length(); j++) {
				char c = exp.charAt(j);
				if(48 <= c) {
					answer.add(c - '0');
				}else {
					int n1 = answer.pop();
					int n2 = answer.pop();
					answer.add(c == '*' ? n1 * n2 : n1 + n2);
				}
			}
			sb.append("#").append(i).append(" ").append(answer.pop()).append("\n");
		}
		out.write(sb.toString());
		out.close();
		in.close();
	}
}
