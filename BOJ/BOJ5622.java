package boj;

import java.util.Scanner;

public class BOJ5622 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		int answer = 0;
		
		for(int i = 0; i < input.length(); i++){
			int num = input.charAt(i);
			if(65 <= num && num < 80) {
				answer += ((num - 65) / 3) + 3;
			}else if(80 <= num){
				if(87 <= num) {
					answer += 10;
				}else if(84 <= num) {
					answer += 9;
				}else answer += 8;
			}
		}
		
		System.out.println(answer);
	}
}