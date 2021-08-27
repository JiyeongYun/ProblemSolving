import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2021-08-27
 * BOJ 2606 - 바이러스 
 * Memory: 11,564KB
 * Execution Time: 84ms 
 */

public class BOJ2606_2 {

	static int answer;
	static int N, M;
	static boolean[][] matrix;
	static boolean[] isVisited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		answer = -1;		// 1번 컴퓨터는 카운트되지 않도록 -1로 초기화
		matrix = new boolean[N + 1][N + 1];
		isVisited = new boolean[N + 1];

		// 네트워크 상에서 직접 연결되어있는 컴퓨터 관계 표시
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			matrix[from][to] = matrix[to][from] = true;
		}

		trace(1);
		System.out.println(answer);
	}

	private static void trace(int computer) {
		isVisited[computer] = true;
		answer++;
		
		for(int i = 1; i <= N; i++) {
			// 해당 컴퓨터와 연결이 되어있고 && 아직 체크하지 않은 컴퓨터인 경우 => trace()
			if(matrix[computer][i] && !isVisited[i])
				trace(i);
		}
	}
}
