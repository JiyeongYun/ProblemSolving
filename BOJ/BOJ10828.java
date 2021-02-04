package boj;

/**
 * 2021-02-04
 * BOJ 10828 - 스택
 * Memory: 15120KB
 * Execution Time: 148ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();
        int N = Integer.parseInt(in.readLine());
        
        while(0 < N--) {
        	
        	String command = in.readLine().trim();
        	
        	if(command.contains("push")) {
        		s.push(Integer.parseInt(command.split(" ")[1])); //split하고 나서 2번째 값
        	}else if(command.equals("pop")) {
        		sb.append(s.empty()? -1 : s.pop()).append("\n");
        	}else if(command.equals("size")) {
        		sb.append(s.size()).append("\n");
        	}else if(command.equals("empty")) {
        		sb.append(s.empty()? 1 : 0).append("\n");
        	}else if(command.equals("top")) {
        		sb.append(s.empty()? -1 : s.peek()).append("\n");
        	}
        }
        
        
        out.write(sb.toString());
        out.close();
        in.close();
	}
}
