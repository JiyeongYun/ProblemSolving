package swea;

/**
 * SWEA 1954 - 달팽이 숫자
 * MEMORY: 20960KB
 * EXECUTION TIME: 132ms
 */

import java.util.Scanner;

public class SWEA1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] d = {{0,1,0,-1}, {1,0,-1,0}};
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			boolean[][] isVisited = new boolean[n][n];
			
			int direction = 0;
			int cnt = 1, row = 0, col = 0;
			
			while(true) {
				if(row == ((n-1) / 2) + ((n-1) % 2) && col == ((n-1) / 2)) {	// 탈출구문
					arr[row][col] = cnt;
					break;
				}
				
				arr[row][col] = cnt++;
				
				
				int x = row + d[0][direction];	//앞으로 갈 x좌표
				int y = col + d[1][direction];	//앞으로 갈 y좌표		
				if(x < 0 || n <= x || y < 0 || n <= y || isVisited[x][y]) {		// 좌표를 넘어섰거나 같은 방향으로 못 가는 경우
					if(direction == 3) direction = 0;
					else direction++;
				}
				isVisited[row][col] = true;
				row += d[0][direction];
				col += d[1][direction];
				
			}
			
			System.out.println("#" + (i+1));
			
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					System.out.print(arr[j][k] + " ");
				}
				System.out.println();
			}		
		}
	}
}
