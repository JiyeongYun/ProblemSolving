package boj;

import java.util.Scanner;

public class BOJ2675 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] numList = new int[n];
		String[] strList = new String[n];
		for(int i = 0; i < n; i++) {
			numList[i] = sc.nextInt();
			strList[i] = sc.next();
		}
		
		for(int i = 0; i < n; i++) {
			String str = strList[i];
			for(int j = 0; j < str.length(); j++) {
				for(int k = 0; k < numList[i]; k++) {
					System.out.print(str.charAt(j));
				}
			}
			System.out.println("");
		}
	}

}
