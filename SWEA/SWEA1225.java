package swea;

/**
 * 2021-02-04
 * SWEA 1225 - 암호생성기
 * Memory: 22,240KB
 * Execution Time: 124ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA1225 {
	
	static final int T = 10;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        for(int t = 1; t <= 10; t++) {
        	in.readLine();	// don't need
        	
        	StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        	for(int i = 0; i < 8; i++) {
        		q.add(Integer.parseInt(st.nextToken()));
        	}
        	
        	int minus = 1;
        	while(true) {
        		if(minus == 6) 
        			minus = 1; 
        		
        		int n = q.remove() - (minus++);
        		if(n <= 0) {
        			q.add(0);
        			break;
        		}
        		q.add(n);
        		
        	}
        	
        	sb.append("#").append(t);
        	while(!q.isEmpty()) {
        		sb.append(" ").append(q.remove());
        	}
        	sb.append("\n");
        	
        }
        out.write(sb.toString());
        out.close(); in.close();
	}
}

