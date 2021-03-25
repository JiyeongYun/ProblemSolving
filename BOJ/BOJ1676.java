package boj;

/**
 * 2021-03-26
 * BOJ 1676 - 팩토리얼 0의 개수 
 * Memory: 11,476KB
 * Execution Time: 80ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1676 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(in.readLine());
		int cnt = 0;
		cnt += N / 5;
		cnt += N / 25;
		cnt += N / 125;
		
		System.out.println(cnt);
		in.close();
	}

}
