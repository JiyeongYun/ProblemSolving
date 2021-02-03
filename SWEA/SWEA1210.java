package swea;

/**
 * 2021-02-03
 * SWEA 1210 - Ladder1
 * Memory: 31188KB
 * Execution Time: 139ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA1210 {

	static int[][] d = {{0, 0, -1}, {-1, 1, 0}};		// left,right,up
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 10; i++) {
        	int n = Integer.parseInt(in.readLine());
        	boolean[][] arr = new boolean[100][100];
        	int row = 0, col = 0;
        	
        	// input
        	for(int j = 0; j < 100; j++) {
        		
        		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        		for(int k = 0; k < 100; k++) {
        			int num = Integer.parseInt(st.nextToken());
        			arr[j][k] = num == 0? false : true;
        			if(num == 2) {
        				row = j; 
        				col = k;
        			}
        		}
        	}	//input done
        	
        	int answer = -1;
        	while(true) {
        		for (int j = 0; j < 3; j++) {	// 갈 수 있는 방향 찾기
    					int x = row + d[0][j];	// 앞으로 갈 x좌표
    					int y = col + d[1][j];	// 앞으로 갈 y좌표	
    					
    					if ((0 <= x && x < 100)   &&   (0 <= y && y < 100)   &&   arr[x][y]) {
    						arr[x][y] = false;
    						row = x;
    						col = y;
    						break;
    					}
    					if(x == 0) {
    						answer = col;
    						break;
    					}
    			}
        	
        		if(answer != -1)
        			break;
        	}
        	
			sb.append("#").append(n).append(" ").append(answer).append("\n");
        }
        
        out.write(sb.toString());
        out.close();
        in.close();

	}

}
