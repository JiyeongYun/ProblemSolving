package swea;

/**
 * 2021-02-08
 * SWEA 1228 - 암호문1
 * Memory: 20,412KB
 * Execution Time: 111ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA1228 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        for(int t = 1; t < 11; t++) {
        	int N = Integer.parseInt(in.readLine());	//원본 암호문의 길이 N, 10 <= N <= 20
        	List<Integer> ll  = new LinkedList<Integer>();
        	StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        	for(int i = 0; i < N; i++) {
        		ll.add(Integer.parseInt(st. nextToken()));
        	}
        	int com = Integer.parseInt(in.readLine());
        	
        	int x, y, s;
        	st = new StringTokenizer(in.readLine(), " ");
        	for(int i = 0; i < com; i++) {
        		switch(st.nextToken().charAt(0)){
        		case 'I':	//삽입
        			x = Integer.parseInt(st.nextToken());	// index
        			y = Integer.parseInt(st.nextToken());	// 작업개수
        			for(int j = 0; j < y; j++) {
        				ll.add(x+j, Integer.parseInt(st.nextToken()));
        			}
        			break;        			
        		}// end of switch
        		
        	}// end of for
        	sb.append("#").append(t);
        	for(int i = 0; i < 10; i++) {	// 앞에서부터 10개항만 출력 
        		sb.append(" ").append(ll.get(i));
        	}
//        	Iterator<Integer> iter = ll.iterator();
//        	while(iter.hasNext()) {
//        		sb.append(" ").append(iter.next());
//        	}
        	sb.append("\n");
        }
        out.write(sb.toString());
        out.close(); in.close();
	}
}
