package boj;

/**
 * 2021-02-09
 * BOJ 11286 절대값 힙
 * Memory: 24424KB
 * Execution Time: 288ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ11286 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        //음수는 내림차순(-1, -2, ...), 양수는 오름차순(1,2,3)
        PriorityQueue<Integer> negative = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> positive = new PriorityQueue<>();	
        
        int N = Integer.parseInt(in.readLine());// N은 연산의 개수, 1 ≤ N ≤ 100,000
        while(0 < N--) {
        	int num = Integer.parseInt(in.readLine());
        	
        	if(num == 0) {		
        		
        		if(positive.isEmpty() && negative.isEmpty()) {	// pos, neg 둘 다 비어있으면 0 출력
        			sb.append("0\n");
        		}else if(positive.isEmpty()) {	// pos가 비어있으면 neg값 추가
        			sb.append(negative.remove()).append("\n");
        		}else if(negative.isEmpty()) {	// neg가 비어있으면 pos값 추가
        			sb.append(positive.remove()).append("\n");
        		}else {							// pos, neg 둘 다 비어있지 않으면 절대값 비교
        			int p = positive.peek();
        			int n = Math.abs(negative.peek());
        			
        			if(p < n) {	// 1 < (-)2 
        				sb.append(positive.remove()).append("\n");
        			}else {		// 3 > (-)2 or 2 === (-)2 
        				sb.append(negative.remove()).append("\n");
        			}
        		}
        		
        	}else if(num > 0) {	// positive number
        		positive.add(num);
        	}else {				// negative number (n<0)
        		negative.add(num);
        	}        	
        }
        out.write(sb.toString());
        out.close(); in.close();
	}
}
