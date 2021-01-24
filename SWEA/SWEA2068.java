package swea;

import java.util.Scanner;

public class SWEA2068 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			int max = Integer.MIN_VALUE;
			for(int j = 0; j < 10; j++) {
				max = Math.max(max, sc.nextInt());
			}	
			
			System.out.println("#" + i + " " + max);
		}

	}

}
