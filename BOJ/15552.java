import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int count = Integer.parseInt(bf.readLine().trim());
    int[] addArr = new int[count];

    for(int i = 0; i < addArr.length; i++){
      String[] arr = bf.readLine().split(" ");
      int n1 = Integer.parseInt(arr[0]);
      int n2 = Integer.parseInt(arr[1]);
      addArr[i] = n1 + n2;
    }
    for(int n : addArr) bw.write(n+"\n");//출력
    bw.flush();
    bw.close();
  }
}

