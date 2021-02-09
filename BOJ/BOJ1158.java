package boj;

/**
 * 2021-02-09
 * BOJ 11866 - 요세푸스 문제
 * Memory: 292844KB
 * Execution Time: 528ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        Queue<Integer> q = new LinkedList<>();
        StringTokenizer s = new StringTokenizer(in.readLine(), " ");
        int n = Integer.parseInt(s.nextToken());
        int k = Integer.parseInt(s.nextToken());
        
        for(int i = 1; i <= n; i++) {
        	q.add(i);
        }
        sb.append("<");
        while(!q.isEmpty()) {
        	for(int i = 0; i < k-1; i++) {
        		q.add(q.remove());
        	}
        	sb.append(q.remove()).append(", ");
        }
        
        sb.setLength(sb.toString().length() - 2);
        sb.append(">");
        out.write(sb.toString());
        out.close();
        in.close();
	}
}

