package boj;

/**
 * 2021-02-17
 * BOJ 2605 - 줄 세우기
 * Memory: 11600KB
 * Execution Time: 80ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2605 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(in.readLine());
        Stack<Integer> front = new Stack<>();
        Stack<Integer> back = new Stack<>();
        
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for(int i = 1; i <= N; i++) {
        	int cnt = Integer.parseInt(st.nextToken());
        	
        	// 횟수만큼 Move front -> back
        	while(0 < cnt--) {
        		back.push(front.pop());
        	}
        	// 해당 값 넣기
        	front.push(i);
        	// 다시 back->front 옮기기
        	while(!back.empty()) {
        		front.push(back.pop());
        	}
        }
        
        while(!front.empty()) {
        	sb.insert(0,front.pop()+" ");
        }
        
        out.write(sb.toString());
        out.close(); in.close();
	}
}
