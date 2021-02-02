package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA1208 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int[] answer = new int[10];
        for(int i = 0; i < 10; i++) {
        	int dump = Integer.parseInt(in.readLine());
        	
        	// 1. input값을 pq(Priority Queue)에 넣는다. - 우선순위가 낮은순, 높은순
        	PriorityQueue<Integer> q = new PriorityQueue<>();							//최상단에 min값 저장	
    		PriorityQueue<Integer> qr = new PriorityQueue<>(Collections.reverseOrder());//최상단에 max값 저장
    		
    		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
    		for(int j = 0; j < 100; j++) {
    			int n = Integer.parseInt(st.nextToken());
    			q.offer(n);
    			qr.offer(n);
    		}
    		
    		// 2. 아래 과정을 n번 반복
    			// 2-1. 제일 위에 값(top), 제일 아래 값(bottom)을 꺼낸다.
    			// 2-2. top--; bottom++;
    			// 2-3. 다시 pq에 넣는다. 
    		for(int j = 0; j < dump; j++) {
    			int min = q.poll();
    			int max = qr.poll();
    			
    			q.remove(max--);
    			qr.remove(min++);
    			
    			q.offer(max);
    			q.offer(min);
    			qr.offer(max);
    			qr.offer(min);
    		}
    			
    		// 3. top-bottom 값 출력
    		answer[i] = qr.poll() - q.poll();
        			
        }
        
        for(int i = 0; i < answer.length; i++) {
        	sb.append("#").append(i+1).append(" ").append(answer[i]).append("\n");
        }
        
        out.write(sb.toString());
        out.close();
        in.close();
	}
}
