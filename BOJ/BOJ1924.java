package boj;

import java.util.Scanner;

public class BOJ1924 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
		int m = sc.nextInt();
		int d = sc.nextInt();
		
		int day = 0;
		for(int i = 0; i < m-1; i++) {
			day += month[i];
		}
		day += d-1;
		System.out.println(week[day % 7]);
	}

}
