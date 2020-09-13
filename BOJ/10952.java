import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Integer> arr = new ArrayList<>();

    while(true){
      int n1 = sc.nextInt();
      int n2 = sc.nextInt();

      if(n1 == 0 && n2 == 0) break;
      arr.add(n1+n2);

    }

    for(int n : arr) System.out.println(n);
  }
}

