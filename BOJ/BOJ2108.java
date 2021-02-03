package boj;


/**
 * 2021-02-03
 * BOJ 2108 - 통계학
 * Memory: 82812KB
 * Execution Time: 912ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class BOJ2108 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        	StringBuilder sb = new StringBuilder();
        	ArrayList<Integer> arr = new ArrayList<>();
        	HashMap<Integer, Integer> m = new HashMap<>();
      
        	int sum = 0;
        	int N = Integer.parseInt(in.readLine());
        	for(int i = 0; i < N; i++) {
        		int n  = Integer.parseInt(in.readLine());
        		arr.add(n);
        		if(m.containsKey(n)) {
        			m.put(n, m.get(n)+1);
        		}else 
				m.put(n, 1);
        		sum += n;
        	}
       
        	// Sorting - arr
        	Collections.sort(arr);
        	// Sorting - map
     		List<Entry<Integer, Integer>> lst = new ArrayList<Entry<Integer, Integer>>(m.entrySet());
     		Collections.sort(lst, new Comparator<Entry<Integer, Integer>>() {
     			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
     				if(o1.getValue() == o2.getValue()) {
     					return o1.getKey().compareTo(o2.getKey());
     				}
     				return o2.getValue().compareTo(o1.getValue());
     			}
     		});
        
        	// 1. 산술평균 - 소수점 이하 첫째 자리에서 반올림한 값을 출력
        	sb.append(Math.round((double)sum/N)).append("\n");

        	// 2. 중앙값
        	sb.append(arr.get(N/2)).append("\n");
                
        	// 3. 최빈값 - 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력
        	int max_key = 0, max_cnt = 0, idx = 0;
        	for(Entry<Integer, Integer> entry : lst) {
        	
        		if(idx == 0) {
        			max_key = entry.getKey();
        			max_cnt = entry.getValue();
        			idx++;
        			continue;
        		}
        		if(idx == 1) {
        			if(max_cnt == entry.getValue()) 	//만약 카운팅 된 개수가 앞의 값과 같다면 -> 이 값을 출력
        				max_key = entry.getKey();
        			break;
        		}
		}
        	sb.append(max_key).append("\n");
        
        	// 4. 범위
        	sb.append(arr.get(arr.size()-1) - arr.get(0)).append("\n");
        
        	out.write(sb.toString());
        	out.close();
        	in.close();
	}
}
