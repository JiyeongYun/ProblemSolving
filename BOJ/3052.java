import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] numArr = new int[10];
    ArrayList<Integer> diffArr = new ArrayList<>();

    for(int i = 0; i < numArr.length; i++){
      int input = sc.nextInt();
      numArr[i] = input%42;
      if(i == 0) {
        diffArr.add(numArr[i]);
        continue;
      }

      boolean isExist = false;
      for(int num : diffArr){
        if(num == numArr[i]){
          isExist = true;
          break;
        }
      }
      if(!isExist){
        diffArr.add(numArr[i]);
      }
    }

    System.out.println(diffArr.size());

  }
}

