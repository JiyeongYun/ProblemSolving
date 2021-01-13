import java.util.Scanner;

public class JO1430 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = {0,0,0,0,0,0,0,0,0,0};
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int total = a * b * c;
		
		while(0 < total) {
			arr[total % 10]++;
			total = total / 10;
		}
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}

