package boj;

/**
 * 2021-03-16
 * BOJ 1759
 * Memory: 12092KB
 * Execution Time: 80ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1759 {

	static int L, C;
	static char[] chr;
	static StringBuilder sb;
	static List<String> answer = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		L = Integer.parseInt(st.nextToken()); // 만들어야 하는 암호 개수
		C = Integer.parseInt(st.nextToken()); // 후보 문자 개수

		char[] password = new char[L];
		chr = new char[C];

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < C; i++) {
			chr[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(chr);
		comb(0, 0, password);

		out.write(sb.toString());
		out.close();
		in.close();
	}

	private static void comb(int cnt, int start, char[] password) {
		if (cnt == L) {
			if (check(password)) {
				sb.append(String.valueOf(password) + "\n");
			}
			return;
		}
		for (int i = start; i < C; i++) {
			password[cnt] = chr[i];
			comb(cnt + 1, i + 1, password);
		}
	}

	static boolean check(char[] password) {
		int vCnt = 0, cCnt = 0;
		for (char c : password) {
			if (c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i') {
				vCnt++;
			} else
				cCnt++;
		}
		return (2 <= cCnt) && (1 <= vCnt) ? true : false;
	}
}
