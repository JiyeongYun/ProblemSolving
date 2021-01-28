package boj;

import java.util.Scanner;

public class BOJ1018 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] c = new char[n][m];
		
		for(int i = 0; i < n; i++) {
			String s = sc.next();
			for(int j = 0; j < m; j++) {
				c[i][j] = s.charAt(j);	
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i = 0; i <= n - 8; i++) {
			for(int j = 0; j <= m - 8; j++) {
				int cntW = 0;
				int cntB = 0;
				for(int row = i; row < i + 8; row++) {
					for(int col = j; col < j + 8; col++) {
						if((row + col) % 2 == 0) {		// 합이 짝수칸 (0,0), (0,2), ..., (1,1), (1,3), ...
							if(c[row][col] != 'W') {	// 시작이 white인 경우
								cntW++;
							}else {
								cntB++;
							}
						}else {							// 합이 홀수칸
							if(c[row][col] != 'B') {
								cntW++;
							}else {
								cntB++;
							}
						}
					}
				}
				min = Math.min(Math.min(Math.min(Math.min(min, cntW), (n*m) - cntW), cntB), (n*m) - cntB);
			}
		}
		System.out.println(min);
	}
}

/**
8 9
BBBBBBBBB
BBBBBBBBB
BBBBBBBBB
BBBBBBBBB
BBBBBBBBB
BBBBBBBBB
BBBBBBBBB
BBBBBBBBW
 */
