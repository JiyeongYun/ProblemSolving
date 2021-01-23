package boj;

import java.util.Scanner;

public class BOJ1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		boolean isDuplicated = false;
		int[] arr = new int[26];
		int max = 0;
		int index = 0;
		
		for(int i = 0; i < input.length(); i++) {
			int num = (int)input.charAt(i);
			if(97 <= num) arr[num-97]++;
			else arr[num-65]++;
		}
		
		
		for(int i =0; i < arr.length; i++) {
			if(max <= arr[i]) {
				if(max == arr[i]) {
					isDuplicated = true;
				}else {
					max = arr[i];
					index = i;
					isDuplicated = false;
				}
			}
		}
		
		if(isDuplicated) System.out.println("?");
		else System.out.println((char)(index+65));

	}

}
