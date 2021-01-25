package boj;

import java.util.Scanner;

public class BOJ1065 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		int num = sc.nextInt();
		
		for(int i = 1; i <= num; i++) {
			if(i < 100) {
				count++;
				continue;
			} 
			
			String strNum = String.valueOf(i);	//int to string
			int n1 = Integer.parseInt(String.valueOf(strNum.charAt(0)));
			int n2 = Integer.parseInt(String.valueOf(strNum.charAt(1)));
			int diff = n2 - n1;
			boolean isSame = true;
			
			for(int j = 2; j < strNum.length(); j++) {
				n1 = Integer.parseInt(String.valueOf(strNum.charAt(j-1)));
				n2 = Integer.parseInt(String.valueOf(strNum.charAt(j)));
				if(n2 - n1 != diff){
					isSame = false;
					break;
				}
			}
			if(isSame) count++;
		}
		
		System.out.println(count);
		sc.close();
	
	}

}
