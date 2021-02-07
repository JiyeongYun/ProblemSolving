package boj;

/**
 * 2021-02-07
 * BOJ 1021 - 회전하는 큐
 * Memory: 11704KB
 * Execution Time: 80ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        
        // Input n, m
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        // Input 1~n in deque
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
        	deque.addLast(i);
        }
        
        int answer = 0;
        st = new StringTokenizer(in.readLine(), " ");
        for(int i = 0; i < m; i++) {
        	int findNum = Integer.parseInt(st.nextToken());
        	int cnt = 0;
        	
        	// Repeat until find the number
        	int num;
        	while(findNum != (num = deque.removeFirst())) {	
        		cnt++;
        		deque.addLast(num);
        	}
        	// Find a smaller value, left(cnt) or right(deque.size()-cnt+1)
        	answer += Math.min(cnt, deque.size() - cnt + 1);
        }
        
        sb.append(answer);
        out.write(sb.toString());
        out.close(); in.close();
	}
}
