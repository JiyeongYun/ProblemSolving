import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1012 {

	static int T, M, N, K;
	static boolean[][] ground;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(in.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			ground = new boolean[N][M];
			
			// 배추 위치 표시하기
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				ground[x][y]= true; 
			}
			
			// 땅 한 칸씩 탐색
			int area = 0;				// area: 구역 개수를 나타내는 변수
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(ground[i][j]) {	// 배추가 심어져있으면 dfs
						dfs(i, j);
						area++;			// 구역하나 증가 
					}
				}
			}
			sb.append(area).append("\n");
		}
		
		out.write(sb.toString());
		out.close();
		in.close();

	}
	
	/**
	 * dfs() - (상하좌우 방향에) 배추가 발견되지 않을 때까지 dfs로 탐색 
	 */
	private static void dfs(int x, int y) {
		
		// 방문한 곳은 false 처리
		ground[x][y] = false;
		
		// 상하좌우 탐색하면서 땅의 유효범위 내에 있고, 배추가 존재할 때 이동
		for(int i =0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(isValid(nx, ny) && ground[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}
	
	/**
	 * isValid() - 땅을 벗어났는지 아닌지 범위 체크하는 함수
	 */
	private static boolean isValid(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}

}

