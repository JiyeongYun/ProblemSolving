import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] countArr = new int[10];
    int num = 1;

    for(int i = 0; i < 3; i++)
      num *= sc.nextInt();

    while(num > 0){
      countArr[num%10]++;
      num/=10;
    }

    for(int i = 0; i < 10; i++) System.out.println(countArr[i]);

  }
}

