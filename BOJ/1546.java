import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<>();
		double avg = 0.0;
		double result=0.0;
		
		double bNum=0.0;
		int num = sc.nextInt();
		
		for(int i =0; i<num; i++){
			int n = sc.nextInt();
			arr.add(n);
		}
		
		for(int i =0; i<arr.size();i++){
			if(bNum<arr.get(i)){
				bNum = arr.get(i);
			}
			result+=arr.get(i);
		}
		
		avg = ((result/(double)num)*100.0)/bNum;
	
		System.out.println(avg);
	
	
	}
}
