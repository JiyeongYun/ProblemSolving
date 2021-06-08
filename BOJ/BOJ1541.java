package boj;

/**
 * 2021-06-08
 * BOJ 1541 - 잃어버린 괄호
 * Memory: 11,520KB
 * Execution Time: 80ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;

		// 1. '-'기준으로 split
		String[] splitMinus = in.readLine().split("-");
		for (int i = 0; i < splitMinus.length; i++) {

			// 2. '+'기준으로 split
			String s = splitMinus[i];

			// 2-1. '+' 기호가 없는 경우 따로 처리
			if (s.indexOf("+") == -1) {
				int num = Integer.parseInt(s);
				sum += (i == 0) ? +num : -num;
			} else {
				String[] splitPlus = s.split("\\+");
				for (int j = 0; j < splitPlus.length; j++) {
					int num = Integer.parseInt(splitPlus[j]);
					sum += (i == 0) ? (+num) : (-num);
				}
			}
		}

		System.out.println(sum);
		in.close();
	}
}
