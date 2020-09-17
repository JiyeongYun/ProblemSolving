import java.util.Scanner;
 
public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        
        if(0<num1&&num2<10){
            int result = num1*num2;
            System.out.println(result);
        }
    }
}
