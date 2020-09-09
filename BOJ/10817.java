import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		Integer[] arr = {a,b,c};
		Arrays.sort(arr,Collections.reverseOrder());
		System.out.println(arr[1]);
	}
}
