package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


/**
 * TRY - 1 	=> TIME LIMIT
 * 단순배열 + Arrays.sort() + println()
 * 
 * TRY - 2 	=> TIME LIMIT
 * ArrayList + Collections.sort() + println()
 * 
 * TRY - 3 	=> TIME LIMIT
 * PriorityQueue + println()
 * 
 * TRY - 4 	=> TIME LIMIT
 * 단순배열 + Arrays.sort() + StringBuilder()
 * 
 * TRY - 5 	=> SUCCESS
 * ArrayList + Collections.sort() + StringBuilder()
 * 
 * TRY - 6 	=> SUCCESS
 * PriorityQueue + StringBuilder()
 * 
 * 
 */ 

public class BOJ2751 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder("");
		ArrayList<Integer> arr = new ArrayList<>();
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			arr.add(sc.nextInt());
		}
		Collections.sort(arr);
		for(int i = 0; i < t; i++) {
			sb.append(arr.get(i)).append("\n");
		}
		System.out.println(sb);
	}
}

