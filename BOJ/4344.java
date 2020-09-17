import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int turn = sc.nextInt();
		
		for(int i =0; i<turn; i++){
			int sum = 0;
			double cnt = 0;
			int num = sc.nextInt();
			
			int[] std = new int[num];
			for(int j = 0; j<num; j++){
				std[j]=sc.nextInt();
				sum+=std[j];
			}
			
			int avg = sum/num;
			for(int k = 0; k<num; k++){
				if(std[k]>avg){
					cnt++;
				}
			}
			System.out.printf("%.3f",(cnt/num)*100);
			System.out.println("%");
		}
	}
}
