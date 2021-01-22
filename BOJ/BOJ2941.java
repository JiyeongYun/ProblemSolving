package boj;

import java.util.Scanner;

public class BOJ2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] alphabetList = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String input = sc.next();
		
		for(int i = 0; i < alphabetList.length; i++) {
			input = input.replace(alphabetList[i], "*");
		}
		
		System.out.println(input.length());
	}
}
