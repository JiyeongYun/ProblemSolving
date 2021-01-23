package boj;

import java.util.Scanner;

public class BOJ1316 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		int num = sc.nextInt();
		
		for(int i =0; i < num; i++) {
			String word = sc.next();
			
			boolean isPossible = true;
			int c = word.charAt(0);
			boolean[] isUsed = new boolean[26];
			for(int j = 0; j < word.length(); j++) {
				
				if(isUsed[word.charAt(j)-97] && c != word.charAt(j)) {
					isPossible = false;
					break;
				}
				isUsed[word.charAt(j)-97] = true;
				c = word.charAt(j);
				 
			}
			
			if(isPossible) count++;
		}
		System.out.println(count);
	}

}
