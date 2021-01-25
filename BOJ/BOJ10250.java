package boj;

import java.util.Scanner;

public class BOJ10250 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] answer = new int[t];
		
		for(int i = 0; i < t; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			
			int floor = n % h;
			if(floor == 0) {
				answer[i] = h * 100  + (n / h);
			}else {
				answer[i] = floor * 100 + ((n / h) + 1);
			}
			
			
		}
		
		for(int i = 0; i < answer.length; i++) 
			System.out.println(answer[i]);
		
		sc.close();
	}

}