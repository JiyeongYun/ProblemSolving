package boj;

/**
 * 2021-02-03
 * BOJ 1181 - 단어 정렬 
 * Memory: 29704KB
 * Execution Time: 280ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Word {
	int l;
	String w;
	
	public Word(int l, String w){
		this.l = l;
		this.w = w;
	}
}


public class BOJ1181 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        	BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        	StringBuilder sb = new StringBuilder();
        	ArrayList<Word> words = new ArrayList<>();
        
        	int t = Integer.parseInt(in.readLine());
        	for(int i = 0; i < t; i++) {
        		String word = in.readLine();
        		words.add(new Word(word.length(), word));		
        	}
        
        	Collections.sort(words, new Comparator<Word>() {
        		public int compare(Word o1, Word o2) {
                		if(o1.l > o2.l) {
					return 1;
                		}else if(o1.l < o2.l) {
                    			return -1;
                		}else {
                			return o1.w.compareTo(o2.w);
                		}
            		}
        	});
        
       	 	String before = "";
        	for(int i = 0; i < words.size(); i++) {
        		String now = words.get(i).w;
        		if(!now.equals(before)) {
        			sb.append(words.get(i).w).append("\n");
        			before = now;
        		}
        	}
        	out.write(sb.toString());
        	out.close();
        	in.close();
	}
}
