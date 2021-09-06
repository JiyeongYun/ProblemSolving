import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {

	public static int[] NList;
	public static StringBuilder sb;
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();

		// Setting about N
		int N = Integer.parseInt(in.readLine());
		NList = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			NList[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(NList);

		// Setting about M
		int M = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < M; i++) {
			int result = search(Integer.parseInt(st.nextToken()), 0, N - 1);
			sb.append(result == -1 ? 0 : 1).append("\n");
		}

		out.write(sb.toString());
		out.close();
		in.close();
	}

	private static int search(int num, int start, int end) {
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;

			if (num == NList[mid]) {
				return mid;
			} else if (num < NList[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return -1;
	}

}
