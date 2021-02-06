package boj;

/**
 * 2021-02-06
 * BOJ 1966 - 프린터 큐
 * Memory: 12452KB
 * Execution Time: 100ms 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        	StringBuilder sb = new StringBuilder();
        
        	int t = Integer.parseInt(in.readLine());
        
        	for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        		int n = Integer.parseInt(st.nextToken());
        		int m = Integer.parseInt(st.nextToken());
        	
        		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        		Queue<int[]> arr = new LinkedList<>();
        		st = new StringTokenizer(in.readLine(), " ");
        	
        		for(int j = 0; j < n; j++) {
        			int num = Integer.parseInt(st.nextToken());
        			arr.add(new int[] {num, j});	// new int {value, idx}
        			pq.add(num);
        		}
        
       		 	int cnt = 0;
        		while(!arr.isEmpty()) {				
        			int num = arr.peek()[0];	
        			int idx = arr.peek()[1];
        		
        			// arr에서 제일 앞에 있는 값이 pq의 제일 앞에 값과 일치하지 않으면, 빼서 맨 뒤로 보내기
        			// pq의 제일 앞에 값: arr에 남아 있는 우선순위가 제일 높은 값
        			while(num < pq.peek()) {		
        				arr.add(arr.remove());
        				num = arr.peek()[0];
        				idx = arr.peek()[1];
        			}
        		
        			// 우선순위가 가장 높은 값 제거
        			cnt++;
				pq.remove();
				arr.remove();
        		
				// 만약 제거한 값이 구해야 하는 idx와 동일하면 break
        			if(idx == m) break;
        		
        		}
        	
	        	sb.append(cnt).append("\n");
        	}
        
        	out.write(sb.toString());
	        out.close(); in.close();
	}
}
