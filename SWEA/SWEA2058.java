package swea;

import java.util.Scanner;

public class SWEA2058 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int quot, rem;
		int answer = 0;
		int num = sc.nextInt();
		
		do {
			quot = num / 10;
			rem = num % 10;
			answer += rem;
			num = quot;
			
		}while(quot > 0);
		System.out.println(answer);
	}
}
