import java.util.Scanner;

public class JO692 {

	public static void main(String[] args) {
		int[] arr = new int[4];
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int _b = b;
		for(int i = 0; i < 3; i++) {
			arr[i] = a * (b % 10); //3
			b = b / 10; // 12			
		}	
		arr[3] = a * _b;
		
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);

		}
		

	}

}

