import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    int count = sc.nextInt();

    int[] score_arr = new int[count];
    String[] message_arr = new String[count];

    for(int i = 0; i < count; i++){
      message_arr[i] = sc.next();
    }

    for(int i = 0; i < count; i++){
      String[] temp = message_arr[i].split("");
      
      int count_zero=0;
      int score = 0;

      for(String str: temp){
        if(str.equals("O")){
          count_zero++;
        }else{
          count_zero = 0;
        }
        score += count_zero;
      }
      score_arr[i] = score;
    }

    for(int i : score_arr){
        System.out.println(i);
    }
  }
}
