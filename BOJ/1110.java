import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int left=0, right=0, sum=0, count=0, result = 0;

		if(10<=num && num<=99){
			left = num/10;
			right = num%10;
			
		}else if(0<=num && num<10){
			left = 0;
			right = num;
		}
		do{
			count++;
			sum = (left+right)%10;
			left = right;
			right = sum;
			
			result = left*10 + right;
		}while(num!=result);
		
		System.out.println(count);

	}
}
