package swea;

/**
 * 2021-02-04
 * SWEA 1218 - 괄호 짝짓기 
 * Memory: 18,660KB
 * Execution Time: 99ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class SWEA1218 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= 10; i++) {
        	Stack<Character> s = new Stack<>();
        	int isMatch = 0;
        	Integer.parseInt(in.readLine());	// don't need
        	String sentence = in.readLine();
        	
        	for(int j = 0; j < sentence.length(); j++) {
        		char c = sentence.charAt(j);
        		if (s.empty() && (c == ')' || c == '}' || c == ']' || c == '>')) {
                    s.add(c);
                    break;
                }
        		if(c == '{' || c == '[' || c == '(' || c == '<') 
        			s.push(c);
        		else if ((c == ')' && s.peek() == '(') || (c == '}' && s.peek() == '{') || (c == ']' && s.peek() == '[') || (c == '>' && s.peek() == '<'))
                    s.pop();
        		else
        			break;
                
        	}
        	
        	if(s.empty()) isMatch = 1;
        	sb.append("#").append(i).append(" ").append(isMatch).append("\n");
        }
        
        out.write(sb.toString());
        out.close(); in.close();
	}
}
