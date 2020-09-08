import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int hour = sc.nextInt();
    int min = sc.nextInt();

    if(min < 45){
      if(hour == 0) hour = 23;
      else hour--;  
      min = min+60-45;
    }else{
      min -= 45;
    }

    System.out.println(hour + " " + min);
  }
}

