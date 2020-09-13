import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cnt = sc.nextInt();
    int[] arr1 = new int[cnt];
    int[] arr2 = new int[cnt];

    for(int i = 0; i < cnt; i++){
      arr1[i] = sc.nextInt();
      arr2[i] = sc.nextInt();
    }

    for(int i = 0; i < cnt; i++){
      System.out.printf("Case #%d: %d + %d = %d\n", i+1, arr1[i], arr2[i], arr1[i]+arr2[i]);
    }
  }
}

