package boj;

/**
 * 2021-02-10
 * BOJ 1655 - 가운데를 말해요
 * Memory: 31544KB
 * Execution Time: 344ms 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ1655 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        	StringBuilder sb = new StringBuilder();
        	PriorityQueue<Integer> upper = new PriorityQueue<>();				// 중간값보다 큰 값 저장 (오름차순: 1,2,3, ...)
        	PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());	// 중간값보다 작은 값 저장 (내림차순: 1,0,-1,-2, ...)
        
        	int T = Integer.parseInt(in.readLine()); 	// 정수의 개수 N, 1 <= N <= 100,000
        	int mid = Integer.parseInt(in.readLine());	// 제일 처음 들어오는 값은 mid로 지정 후 출력
        	sb.append(mid).append("\n");
        
        	for(int t = 1; t < T; t++) {
        		int n = Integer.parseInt(in.readLine());	
        								// *** EXAMPLE ***
        		if(mid <= n) {					// mid= 3, n= 5
        			upper.add(n);				// upper.add(5)
        								// [1,3,4]에서 mid(=3)보다 더 큰 5가 들어와도 mid는 계속 3
        			if(t % 2 == 0) {			// 그러나, [1,3,4,7]에서 mid(=3)보다 더 큰 5가 들어오면 mid는 lower로 밀려나고
        				lower.add(mid);			
        				mid = upper.remove();		// upper에서 가장 작은 값을 mid로 이동 
        			}					// ===================================================================
        		}else {						// mid= 3, n= 1
        			lower.add(n);				// lower.add(1)
        								// [2,3,4,7]에서 mid(=3)보다 작은 값 1이 들어와도 mid는 계속 3
        			if(t % 2 == 1) {			// 그러나, [2,2,3,4,7]에서 mid(=3)보다 더 작은 1이 들어오면 mid는 upper로 밀려나고
        				upper.add(mid);
        				mid = lower.remove();		// lower에서 가장 큰 값을 mid로 이동 (lower은 내림차순이기 때문에 제일 앞에 가장 큰 값이 있음)
        			}
        		}
        		sb.append(mid).append("\n");	
        	}
        	out.write(sb.toString());
        	out.close(); in.close();
	}
}
