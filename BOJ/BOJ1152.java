package boj;

import java.util.Scanner;

public class BOJ1152 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		String[] arr = sc.nextLine().split(" ");
		for(int i = 0; i < arr.length; i++) {
			if(!arr[i].equals("")) count++;
		}
		System.out.println(count);	
	}

}
