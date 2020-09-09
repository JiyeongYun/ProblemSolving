import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int max = -1000000, min = 1000000;
    int cnt = sc.nextInt();
    int[] score_arr = new int[cnt];

    for(int i = 0; i < cnt; i++){
      score_arr[i] = sc.nextInt();
      if(score_arr[i] > max) max = score_arr[i];
      if(min > score_arr[i]) min = score_arr[i];
    }
    
    System.out.println(min+" "+max);
    
  }
}
