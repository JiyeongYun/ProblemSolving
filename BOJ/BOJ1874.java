package boj;

/**
 * 2021-02-03
 * BOJ 1874 - 스택 수열
 * Memory: 28,128KB	
 * Execution Time: 320ms 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> s = new Stack<>();
        int n = Integer.parseInt(in.readLine());
        int[] input = new int[n];
        
        // input
        for(int i = 0; i < n; i++) {
        	input[i] = Integer.parseInt(in.readLine());
        }
        
        // calculate
        int inputIdx= 0;
        int num = 1;
        boolean isBreak = false;
        while(true) {		// input 끝까지 가라 !
        	
        	// stack에 넣다가 같아지면 break!
        	while(true) {			
        		s.push(num);
        		sb.append("+\n");
        		if(num == input[inputIdx]) 
        			break;
        		num++;
        	}
        	
        	// stack에서 빼다가 비교대상과 달라지면 break! 
        	num++;
        	while(true) {
        		if(s.empty() || inputIdx == n || s.peek() != input[inputIdx]) {
        			if(inputIdx == n) 
        				isBreak = true;
        			break;
        		}
        		s.pop();
        		sb.append("-\n");
        		inputIdx++;
        	}
        	
        	// 탈출하라는 신호가 있었는가? 
        	if(isBreak) break;
        	
        	// 성공하지 못하는 CASE 처리 
        	if(!s.empty() && input[inputIdx] < s.peek()) {
        		sb = new StringBuilder();
        		sb.append("NO");
        		break;
        	}
        }
        
        out.write(sb.toString());
        out.close();
        in.close();
	}
}
