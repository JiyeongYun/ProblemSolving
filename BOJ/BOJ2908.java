package boj;

import java.util.Scanner;

public class BOJ2908 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int answer = n1;
		
		for(int i = 0; i < 3; i++) {
			int d1 = ((int) (n1 / (Math.pow(10, i)))) % 10;
			int d2 = ((int) (n2 / (Math.pow(10, i)))) % 10;
			
			if(d1 == d2) continue;
			if(d1 > d2) answer = n1;
			else answer = n2;
			break;
		}
		
		for(int i = 0; i < 3; i++) {
			System.out.print(((int) (answer / (Math.pow(10, i)))) % 10);
		}
	}
}
