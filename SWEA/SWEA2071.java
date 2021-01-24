package swea;

import java.util.Scanner;

public class SWEA2071 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] answer = new int[n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 10; j++) {
				answer[i] += sc.nextInt();
			}	
		}
		
		for(int i = 0; i < n; i++) {
			if(answer[i]%10 < 5) System.out.println("#" + (i+1) + " " + (answer[i]/10));
			else System.out.println("#" + (i+1) + " " + ((answer[i]/10) + 1));
		}
	}
}
