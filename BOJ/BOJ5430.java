package boj;

/**
 * 2021-02-07
 * BOJ 5430 - AC
 * Memory: 151796KB
 * Execution Time: 1196ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BOJ5430 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine());
        while(0 < T--) {
        	Deque<Integer> deque = new ArrayDeque<>();
        	
        	// input 
        	String _p = in.readLine();
        	String[] p = _p.split("");
        	int size = Integer.parseInt(in.readLine());
        	
        	
        	String _str =  in.readLine().replace("[","").replace("]", "");
        	String[] str = _str.length() > 0 ? _str.split(",") : null; 	// 배열 안에 있는 값들이 하나라도 존재하는 경우 split
        	
        	// 함수에서 D가 포함되어 있는데, 배열에는 값이 없는 경우 ERROR
        	if(size == 0 && _p.contains("D")) {
        		sb.append("error\n");
        		continue;
        	}
        	
        	// 배열 안에 있는 값들이 하나라도 존재하는 경우 덱에 하나씩 추가 
        	if(str!=null) {
        		for(int i = 0; i < str.length; i++) {
            		deque.addLast(Integer.parseInt(str[i]));
            	}
        	}
        	
        	// 앞에서 뺄지 뒤에서 뺄지 기준값 -> 초반에 데이터를 뒤에서 하나씩 넣었으므로 빼는 건 앞에서 뺀다. 
        	boolean isFirst = true;
        	// 에러로 for문을 탈출한 건지 아닌지의 기준 값
        	boolean isNotError = true;
        	
        	
        	for(int i = 0; i < _p.length(); i++) {
        		
        		// R이 나왔으면 빼는 위치 변경 
        		if(p[i].equals("R")){	//뒤집기
        			isFirst = !isFirst;
        		}else {					//삭제하기
        			Integer result = isFirst? deque.pollFirst() : deque.pollLast();
        			if(result == null) {
        				sb.append("error\n");
        				isNotError = false;
        				break;
        			}
        		}
        		
        	}
        	
        	// 에러로 for문을 탈출한 게 아니면 if문 실행 
        	if(isNotError) {
        		sb.append("[");
        		
        		// 배열이 하나 이상 있으면 true, 없으면 false 
        		boolean isExist = false;
        		
        		// 덱에 남은 값을 하나씩 pop
        		while(!deque.isEmpty()) {
        			sb.append(isFirst? deque.pollFirst() : deque.pollLast()).append(",");
        			isExist = true;
        		}
        		
        		// 배열이 하나 이상 있으면 마지막 원소에서 추가된 ',' 콤마 삭제 
        		if(isExist) {
        			sb.setLength(sb.length()-1);
        		}
        		
        		sb.append("]\n");
        	}
        		
        }
        
        out.write(sb.toString());
        out.close(); in.close();
	}
}


/*
2
D
0
[]
RDD
4
[1,2,3,4]




4
D
0
[]
RDD
4
[1,2,3,4]
DD
1
[42]
RRD
6
[1,1,2,3,5,8]


 **/
