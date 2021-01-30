package boj;

import java.util.Scanner;

public class BOJ16283 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int n = sc.nextInt();
		int w = sc.nextInt();
		int x = 0, y = 0, cnt = 0, sheep;
		
		for(sheep = 1; sheep < n; sheep++) {
			if(sheep * a + (n - sheep) * b == w) {
				cnt++;
				x = sheep;
				y = n - sheep;
			}
		}
		if(cnt != 1) System.out.println(-1);
		else System.out.println(x + " " + y);
	}
}
