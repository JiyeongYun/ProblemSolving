package swea;

import java.util.Scanner;

public class SWEA2070 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			System.out.print("#" + i + " ");
			System.out.println(n1 > n2 ? ">" : n1 < n2 ? "<" : "=");
		}
	}
}
