package swea;


/**
 * 2021-02-05
 * SWEA 1861 - 정사각형 방
 * Memory: 27,780KB
 * Execution Time: 142ms
 */ 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA1861 {
	
	private static int N;
	private static int[][] arr;
	private static int[][] memo;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(in.readLine());
        for(int t = 1; t <= T; t++){
        	N = Integer.parseInt(in.readLine());
            arr = new int[N][N];
            memo = new int[N][N];	//탐색한 결과값을 저장할 배열            
            
            // input 
        	for(int i = 0; i < N; i++) {
        		st = new StringTokenizer(in.readLine(), " ");
        		for(int j = 0; j < N; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        		
        	int max = 0;			//최대 이동할 수 있는 방의 개수
        	int num = Integer.MAX_VALUE;        //최대 이동을 위해 출발할 방의 위치(숫자)	
        	for(int i = 0; i < N; i++) {	//모든 방에서 출발해서 탐색
        		for(int j = 0; j < N; j++) {	
        			int val = go(i,j);		// i,j 위치에서 출발하여 이동할 수 있는 최대 방의 개수를 리턴 
        			if(max < val ||( max == val && arr[i][j] < num)) {
        				max  = val;
        				num = arr[i][j];
        			}
        		}
        	}
     
        	sb.append("#").append(t).append(" ").append(num).append(" ").append(max).append("\n");
        } // end of Test Case
        out.write(sb.toString());
        out.close();
        in.close();
	}	// end of main

	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	/** arr[i][j] 방에서 출발하여 최대 이동할 수 있는 방의 개수를 리턴하는 메서드**/
	private static int go(int r, int c) {
		if(memo[r][c] != 0) 	// 탐색한 기록이 있는가?
			return memo[r][c];	// 중복 호출 제거 
		
		memo[r][c] = 1;	//몇 칸 갈 수 있는지 저장할 변수
		int num = arr[r][c];	//현재 방의 숫자 
		
		for(int i = 0; i < dr.length; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			
			if(0 <= nr && nr < N && 0 <= nc && nc < N && arr[nr][nc] == num + 1) {	// 배열 범위 안쪽인지, 이동할 수 있는지 check 
				memo[r][c] += go(nr, nc);
				break;
			}
		}
		
		return memo[r][c];
	}
}
