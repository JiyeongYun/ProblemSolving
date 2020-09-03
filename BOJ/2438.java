import java.util.*;

class Main
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if(1 <= num && num <= 100){
			for(int i = 1; i <= num; i++){
				for(int j = 1; j <= i; j++){
					System.out.print("*");
				}
				System.out.print("\n");
			}
		}
	}
}
