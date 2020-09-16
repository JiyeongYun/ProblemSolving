import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		if(0<=s && s<=100){
			String str="F";
			if(90<=s && s<=100){
				str = "A";
			}else if(80<=s && s<90){
				str = "B";
			}else if(70<=s && s<80){
				str = "C";
			}else if(60<=s && s<70){
				str = "D";
			}
			System.out.println(str);
		}
	}
}
