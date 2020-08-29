import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
    
        if(0 < a && b < 10){
    	    double c = a/b;
            System.out.println(c);
        }
	}
}
