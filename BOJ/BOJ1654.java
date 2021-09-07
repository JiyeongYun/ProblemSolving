import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int lines[] = new int[K];
	
		for(int i = 0; i < K; i++) {
			lines[i] = Integer.parseInt(in.readLine());
		}
		Arrays.sort(lines);
		
		long left = 1, right = lines[K-1];
		long answer = 1;
		while(left <= right) {		
			long mid = (left + right) / 2;
			long sum = 0;
			
			// 총 몇개의 랜선이 만들어지는지 구하기
			for(int i = 0; i < K; i++) {
				sum += lines[i]/mid; 
			}
			
			if(N <= sum) {
				answer = Math.max(answer, sum);
				left = mid + 1;
			}
				
			else
				right = mid - 1;
		}
		
		System.out.println(right);
		in.close();

	}
}
