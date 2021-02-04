package boj;

/**
 * 2021-02-04
 * BOJ 2493 - 탑 
 * Memory: 121,308KB
 * Execution Time: 716ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        
        int N = Integer.parseInt(in.readLine());
        int[] answer = new int[N+1];	//왼큰수
        Stack<Integer> arr = new Stack<>();
        Stack<Integer> arrIdx = new Stack<>();
        Stack<Integer> notFnd = new Stack<>();
        Stack<Integer> notFndIdx = new Stack<>();
        
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        for(int i = 1; i <= N; i++) {
        	arr.push(Integer.parseInt(st.nextToken()));
        	arrIdx.push(i);
        }	//1:6, 2:9, 3:5, 4:7, 5:4
        
        int now = arr.pop();
        int nowIdx = arrIdx.pop();
        while(!arr.empty()) {	// 역순으로 뽑히면서 
        	int next = arr.pop();
        	int nextIdx = arrIdx.pop();
        	
        	if(now < next) {					// 자신 다음 나오는 수가 자기보다 크면 
        		answer[nowIdx] = nextIdx;		// 그 수의 idx를 저장하기 
        		while(!notFnd.empty() && notFnd.peek() < next) {	// 아직 처리되지 못한 수 중에 조건에 맞으면 처리해주기  
        			notFnd.pop();
        			answer[notFndIdx.pop()] = nextIdx;
        		}
        	}else {								// 자신 다음 나오는 수가 자신보다 크지 않으면 나중에 처리하기 위해 잠시 stack에 넣기
        		notFnd.push(now);
        		notFndIdx.push(nowIdx);			// index도 같이!
        	}
        	
        	now = next;							// change
        	nowIdx = nextIdx;
        	
        }
        
        answer[nowIdx] = 0;						// 제일 처음 나온 수는 왼쪽에 수가 존재하지 않기 때문에 0
        while(!notFnd.empty()) {				// 처리되지 못한 수는 없다는 뜻. ==> 고로 0
        	notFnd.pop();
        	answer[notFndIdx.pop()] = 0;
        }
        
        for(int i = 1; i < answer.length; i++) {
        	sb.append(answer[i]).append(" ");
        }
       
        out.write(sb.toString());
        out.close(); in.close();
	}
}
