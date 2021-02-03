package boj;

/**
 * 2021-02-03
 * BOJ 4949 - 균형잡힌 세상
 * Memory: 17020KB
 * Execution Time: 164ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class BOJ4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        String sentence = in.readLine();
        while(!sentence.equals(".")) {
        	Stack<Character> s = new Stack<>();
        	char[] c = sentence.toCharArray();
        	boolean isMatch = true;
        	for(int i = 0; i < c.length; i++) {
        		if( c[i] == '[' || c[i] == '(' ) {
        			s.push(c[i]);
        		}
        		
        		else {
        			if((c[i] == ']' ||  c[i] == ')') && s.empty()) {
        				isMatch = false;
        				break;
        			}
        			if(c[i] == ']') {
        				if(s.peek() == '[') {
        					s.pop();
        				}else {
        					isMatch = false;
        					break;
        				}
        			}else if(c[i] == ')') {
        				if(s.peek() == '(') {
        					s.pop();
        				}else {
        					isMatch = false;
        					break;
        				}
        			}
        			
        		}
        	}
        	
        	if(isMatch && s.empty()) sb.append("yes").append("\n");
        	else sb.append("no").append("\n");
        	sentence = in.readLine();
        }
        
        out.write(sb.toString());
        out.close();
        in.close();

	}

}
