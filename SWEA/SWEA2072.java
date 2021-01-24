package swea;

import java.util.Scanner;

public class SWEA2072 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] answer = new int[n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 10; j++) {
				int num = sc.nextInt();
				if(num % 2 == 1) answer[i] += num;
			}	
		}
		
		sc.nextLine();
		for(int i = 0; i < n; i++) {
			System.out.println("#" + (i+1) + " " + answer[i]);
		}
	}
}
