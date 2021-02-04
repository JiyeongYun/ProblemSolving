package boj;

/**
 * 2021-02-04
 * BOJ 10773 - 제로
 * Memory: 21296KB
 * Execution Time: 196ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ10773 {
	
	// 방법 1 - stack에서 값을 넣고 뺄 때마다 total 값 변환하기 => 196ms 
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        Stack<Integer> memo = new Stack<>();
        int N = Integer.parseInt(in.readLine());
        int total = 0;
        while(0 < N--) {
        	int n = Integer.parseInt(in.readLine());
        	if(n == 0) {
        		total-=memo.pop();
        	}else {
        		memo.push(n);
        		total+=n;
        	}
        }
        
        sb.append(total);
        
        out.write(sb.toString());
        out.close();
        in.close();

	}
	
	// 방법 2 - 모든 명령어 수행 후 최종적으로 stack에 남은 값만 더하기 => 220ms
	
//	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
//        
//        Stack<Integer> memo = new Stack<>();
//        int N = Integer.parseInt(in.readLine());
//        int total = 0;
//        while(0 < N--) {
//        	int n = Integer.parseInt(in.readLine());
//        	if(n == 0) {
//        		memo.pop();
//        	}else {
//        		memo.push(n);
//        	}
//        }
//        
//        while(!memo.empty()) {
//        	total += memo.pop();
//        }
//        sb.append(total);
//        
//        out.write(sb.toString());
//        out.close();
//        in.close();
//
//	}

}