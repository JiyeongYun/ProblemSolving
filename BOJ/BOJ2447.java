package boj;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2447 {
	static char[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new char[n][n];
		
		// Fill in the array with blank spaces
		for(int i = 0; i < n; i++) {
			Arrays.fill(arr[i],' ');
		}
		
		// Call a recursive function: print(pointX, pointY, size)
		print(0, 0, n);
		
		// Print the array one row at a time
		for(int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void print(int x, int y, int n) {
		if(n == 1) { 						// Point at end of recursive call
			arr[x][y] = '*';
			return;
		}
		
		int div = n / 3; 					// Continue to divide the input n values by 3
		for(int i = 0; i < 3; i++) { 		// Make a star 3x3 size.
			for(int j = 0; j < 3; j++) {
				if(i == 1 && j == 1)		
					continue;
				print( x + (div * i), y + (div * j), div); 
			}
		}
	}

}
