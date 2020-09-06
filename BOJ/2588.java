import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num1 = sc.nextInt();
    int num2 = sc.nextInt();
    int result = num1*num2;

    for(int i = 0; i < 3; i++){
      System.out.println(num1 * (num2%10));
      num2/=10;
    }

    System.out.println(result);
  }
}

