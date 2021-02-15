package boj;

/**
 * 2021-02-15
 * BOJ 2961 - 도영이가 좋아하는 음식 
 * Memory: 12456KB
 * Execution Time: 80ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2961 {
	
	static int N, minValue = Integer.MAX_VALUE;;
	static int[][] material;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(in.readLine());
        material = new int[N][2];
        
        for(int i = 0; i < N; i++) {
        	StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        	material[i][0] = Integer.parseInt(st.nextToken());
        	material[i][1] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = N; 1 <= i; i--) {	// 1, 2, ..., n개 뽑기 
        	int[] combArr = new int[N];
        	comb(combArr, i, 0, 0);
        }
        
        out.write(sb.append(minValue).toString());
        out.close(); in.close();
	}
	private static void comb(int[] combArr, int r, int index, int target){
        if(r == 0){
        	int s = 1;	// 신맛
        	int b = 0;	// 쓴맛
            for(int i = 0; i < index; i++) {
            	s *= material[combArr[i]][0];
            	b += material[combArr[i]][1];
            }
            minValue = Math.min(Math.abs(s-b), minValue);
            
        } else if(target == N) {
        	return;
        } else{
            combArr[index] = target;
            comb(combArr, r - 1, index + 1, target + 1); 
            comb(combArr, r, index, target + 1);
        }
    }
}
