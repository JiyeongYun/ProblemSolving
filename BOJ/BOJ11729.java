package boj;

import java.util.Scanner;

public class BOJ11729 {
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sb.append((int)Math.pow(2, n)-1 + "\n");
		hanoi(n, 1, 3, 2);
		
		System.out.println(sb);
	}
	
	public static void hanoi(int n, int s, int d, int r) {
		if(n == 1) {
			sb.append(s + " " + d + "\n");
			return;
		}	
		hanoi(n-1, s, r, d);
		sb.append(s + " " + d + "\n");
		hanoi(n-1, r, d, s);
	}

}
