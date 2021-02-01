package boj;

/*
2021-02-01
BOJ 1244
Memory: 13340KB
Execution Time: 128ms
*/

import java.util.Scanner;

public class BOJ1244 {
	
	public static int[] switches;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		switches = new int[n];
		for(int i = 0; i < n; i++) {
			switches[i] = sc.nextInt();
		}
		
		int stdNum = sc.nextInt();
		for(int i = 0; i < stdNum; i++) {
			int gender = sc.nextInt();
			int pos = sc.nextInt();
			
			if(gender == 1) {
				male(pos);
			}else {
				female(pos);
			}
		}
		
		for(int i = 0; i < n; i++) {
            if(i != 0 && i % 20 == 0) System.out.println();
			System.out.print(switches[i] + " ");
		}

	}
	
	public static void male(int pos) {
		for(int i = 1; i * pos <= switches.length; i++) {
			switches[i*pos-1] = (switches[i*pos-1] == 0)? 1 : 0;   	
        }
	}
	
	public static void female(int pos) {
		int l = pos-1;
		int r = pos-1;
		while(true) {	
			l--;
			r++;
			if(l < 0 || switches.length <= r || switches[l] != switches[r]){
				l++;
				r--;
				break;
			}
		}
		
		for(int i = l; i <= r; i++) {
			switches[i] = (switches[i] == 0)? 1 : 0;
		}
	}
}
