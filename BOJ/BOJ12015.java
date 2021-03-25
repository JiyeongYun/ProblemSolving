package boj;

/**
 * 2021-03-25
 * BOJ 12015 - 가장 긴 증가하는 부분 수열 2 
 * Memory: 122,660KB
 * Execution Time: 464ms
 */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ12015 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N]; 
		int[] LIS = new int[N]; 

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int size = 0;
		for (int i = 0; i < N; i++) {
			int temp = Arrays.binarySearch(LIS, 0, size, arr[i]);
			if(temp < 0) temp = Math.abs(temp) - 1;
			LIS[temp] = arr[i]; 
			if (temp == size) ++size;
		}

		System.out.println(size);
		in.close();
	}
}
