package swea;

/**
 * 2021-02-05
 * SWEA 3499 - 퍼펙트 셔플
 * Memory: 24,012KB
 * Execution Time: 124ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA3499 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(in.readLine());
        for(int t = 1; t <= T; t++) {
        	int n = Integer.parseInt(in.readLine());
        	ArrayList<String> arr = new ArrayList<>();
        	StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        	for(int i = 0; i  < n; i++) {
        		arr.add(st.nextToken());
        	}
        
        	sb.append("#").append(t).append(" ");
        	if(n % 2 == 0) {
        		n = n/2;
        		for(int i = 0; i < n; i++) 
            		sb.append(arr.get(i)).append(" ").append(arr.get(i + n)).append(" ");
        	}else {
        		n = n/2;
        		for(int i = 0; i < n; i++)
            		sb.append(arr.get(i)).append(" ").append(arr.get(i + n + 1)).append(" ");
        		sb.append(arr.get(n));
        	}
        	sb.append("\n");
        }
        out.write(sb.toString());
        out.close(); in.close();
	}
}




