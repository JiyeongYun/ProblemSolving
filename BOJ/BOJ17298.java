package boj;

/**
 * 2021-02-04
 * BOJ 17298 - 오큰수 
 * Memory: 225,484KB...
 * Execution Time: 1172ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
		
        int N = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        Stack<Integer> arr = new Stack<>();
        Stack<Integer> arrIdx = new Stack<>();
        int[] answer = new int[N];	//오큰수 
        
        
        int now = Integer.parseInt(st.nextToken());
        for(int i = 1; i < N; i++) {
        	int next = Integer.parseInt(st.nextToken());
        	
        	if(now < next) {
        		answer[i-1] = next;
        		while(!arr.empty() && arr.peek() < next) {	//숫자도 빼고 idx도 빼서 해당 idx위치에 오큰수 넣기!!
        			arr.pop();        			
        			answer[arrIdx.pop()] = next;
        		}
        	}else {
        		arr.push(now);
        		arrIdx.push(i-1);
        	}
        	now = next;
        	
      	}
        
        answer[N-1] = -1;
        while(!arr.empty()) {
        	arr.pop();
        	answer[arrIdx.pop()] = -1;
        }
       
        for(int n : answer) {
        	sb.append(n).append(" ");
        }
        
        out.write(sb.toString());
        out.close(); in.close();
	}

	/*************************
	 ** TIME LIMIT - O(N^2) **
	 *************************/
//	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
//        
//        Queue<Integer> q = new LinkedList<>();
//        int N = Integer.parseInt(in.readLine());
//        StringTokenizer s = new StringTokenizer(in.readLine(), " ");
//        for(int i = 0; i < N; i++) {
//        	q.add(Integer.parseInt(s.nextToken()));
//        }
//        
//        for(int i = 0; i < N; i++) {
//        	int top = q.remove();
//        	int time = N-1-i;
//        	int maxNum = 0;
//        	boolean isExist = false;
//        	for(int j = 0; j < time; j++) {
//        		int num = q.remove();
//        		q.add(num);
//        		if(isExist) continue;
//        		if(num > top) {
//        			maxNum = num;
//        			isExist = true;
//        		}
//        	}
//        	sb.append(isExist ? maxNum : -1).append(" ");
//        }
//        
//        out.write(sb.toString());
//        out.close(); in.close();
//	}
}
