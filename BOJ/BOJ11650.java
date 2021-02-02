/**
 * BOJ 11650 - 좌표 정렬하기
 * MEMORY: 61192KB
 * EXECUTION TIME: 612ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ11650 {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(in.readLine());	
        int[][] arr = new int[t][2];
        
        for(int i = 0; i < t; i++) {
        	StringTokenizer st = new StringTokenizer(in.readLine()," ");
        	arr[i][0] = Integer.parseInt(st.nextToken());
        	arr[i][1] = Integer.parseInt(st.nextToken());
		}
        
        Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) return o1[1] - o2[1];
				else return o1[0] - o2[0];
			}
        });
        
        for(int i = 0; i < t; i++) {
        	sb.append(arr[i][0]).append(" ").append(arr[i][1]).append(" \n");
		}
        
        out.write(sb.toString());
        out.close();
        in.close();
        
	}

}
