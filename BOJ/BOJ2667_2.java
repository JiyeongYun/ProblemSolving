import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2667_2 {

	static int N, index;
	static boolean[][] grid;
	static boolean[][] isVisited;
	static ArrayList<Integer> answer;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(in.readLine());
		grid = new boolean[N][N];
		isVisited = new boolean[N][N];
		answer = new ArrayList<>();

		// 지도에 집 입력하기
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < N; j++) {
				if (line.charAt(j) - '0' == 1) {
					grid[i][j] = true;
				}
			}
		}

		index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] && !isVisited[i][j]) {
					answer.add(0);
					trace(i, j);
					index++;
				}
			}
		}

		// 오름차순 정렬
		Collections.sort(answer);
		
		// 사이즈 출력
		sb.append(answer.size()).append("\n");
		
		// 단지 개수 출력
		for (int i = 0; i < answer.size(); i++) {
			sb.append(answer.get(i)).append("\n");
		}
		
		// 결과 출력
		out.write(sb.toString());
		out.close();
		in.close();

	}

	private static void trace(int x, int y) {
		isVisited[x][y] = true; 				// 방문처리
		answer.set(index, answer.get(index)+1); // 집 개수

		
		// 상하좌우 방향에서 조건에 맞으면 trace()
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (isValid(nx, ny) && grid[nx][ny] && !isVisited[nx][ny]) {
				trace(nx, ny);
			}
		}
	}
	
	// Check the boundary
	private static boolean isValid(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

}
