import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
	    int count = sc.nextInt();
        int limit = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i< count; i++){
            int num = sc.nextInt();
            arr.add(num);
        }
        for(int i = 0; i< arr.size(); i++){
            if(arr.get(i)<limit){
                System.out.print(arr.get(i)+" ");   
            }
        }
	}
}
