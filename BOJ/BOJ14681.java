package boj;

/**
 * 2021-01-15
 * BOJ 14681 - 사분면 고르기
 * Memory: 11,452KB
 * Execution Time: 80ms 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ14681 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(in.readLine());
		int Y = Integer.parseInt(in.readLine());
		int answer = X > 0 ? Y > 0 ? 1 : 4 : Y > 0 ? 2 : 3 ;
		System.out.println(answer);
		in.close();
	}
}
