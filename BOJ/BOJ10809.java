package boj;

import java.util.Scanner;

public class BOJ10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();

		for(int i = 97; i < 123; i++) {
			int idx = input.indexOf(String.valueOf((char)i));
			System.out.print(idx + " ");
		}
	}
}
