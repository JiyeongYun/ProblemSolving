import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int max = -1000000;
    int max_index = -1;
    int[] numArr = new int[9];

    for(int i = 0; i < 9; i++){
      numArr[i] = sc.nextInt();
      if(numArr[i] > max) {
        max = numArr[i];
        max_index = i+1;
      }
    }

    System.out.println(max);
    System.out.println(max_index);

  }
}
