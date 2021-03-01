package boj;

/**
 * 2021-03-01
 * BOJ 9012 - 괄호 짝짓기
 * Memory: 11744KB
 * Execution Time: 80ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		int T = Integer.parseInt(in.readLine());
		while (0 < T--) {
			stack.clear();
			String str = in.readLine();
			boolean isPossible = true;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				if (c == '(') {
					stack.push(c);
				} else if (stack.isEmpty() || stack.pop() != '(') {
					isPossible = false;
					sb.append("NO\n");
					break;
				}
			}

			if (!stack.isEmpty())
				sb.append("NO\n");
			else if (isPossible) {
				sb.append("YES\n");
			}

		}

		out.write(sb.toString());
		out.close();
		in.close();
	}
}
