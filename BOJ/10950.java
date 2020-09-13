import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cnt = sc.nextInt();
    int[] addArr = new int[cnt];

    for(int i = 0; i < addArr.length; i++){
      int n1 = sc.nextInt();
      int n2 = sc.nextInt();
      addArr[i] = n1+n2;
    }
    for(int n : addArr) System.out.println(n);
  }
}

