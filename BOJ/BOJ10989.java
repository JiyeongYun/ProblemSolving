/**
 * BOJ 10989 - 수 정렬하기3
 * MEMORY: 480768KB
 * EXECUTION TIME: 1692ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ10989 {
	///////////////////////////////////////////////////////////////////////////////////
	// SUCCESS (BufferedReader, BufferWriter, StringBuilder + Advanced Counting Sort)//
	///////////////////////////////////////////////////////////////////////////////////
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
        final int MAX = 10000;
		int[] cntArr = new int[MAX+1];
		int n = Integer.parseInt(in.readLine());	
	
		for(int i = 0; i < n; i++) {
			cntArr[Integer.parseInt(in.readLine())]++;
		}

		StringBuilder sb = new StringBuilder("");
		for(int i = 1; i < (MAX+1); i++) {
			while(cntArr[i] > 0){
				sb.append(i).append("\n");
				cntArr[i]--;
			}
		}
		
		out.write(sb.toString());
		out.close();
		in.close();
	}
 	///////////////////////////////////////////////////////////////////////
	// TIME LIMIT - 03: (Scanner, StringBuilder + Advanced Counting Sort)//
	///////////////////////////////////////////////////////////////////////
	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		final int MAX = 10000;
//		
//		int[] cntArr = new int[MAX+1];
//		int n = sc.nextInt();	
//	
//		for(int i = 0; i < n; i++) {
//			cntArr[sc.nextInt()]++;
//		}
//
//		StringBuilder sb = new StringBuilder("");
//		for(int i = 1; i < (MAX+1); i++) {
//			while(cntArr[i] > 0){
//				sb.append(i).append("\n");
//				cntArr[i]--;
//			}
//		}
//		
//		System.out.print(sb);
//	}
	///////////////////////////////////////////////////////////////////
	// TIME LIMIT - 02: (Scanner, println() + Advanced Counting Sort)//
	///////////////////////////////////////////////////////////////////
	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//        final int MAX = 10000;
//		int[] cntArr = new int[MAX+1];
//		int n = sc.nextInt();
//	
//		for(int i = 0; i < n; i++) {
//			cntArr[sc.nextInt()]++;
//		}
//
//		for(int i = 1; i < (MAX+1); i++) {
//			while(cntArr[i] > 0){
//				System.out.println(i);
//				cntArr[i]--;
//			}
//		}
//
//	}
	
	///////////////////////////////////////////////////////////////////
	// TIME LIMIT - 01: (Scanner, println() + General Counting Sort)///
	///////////////////////////////////////////////////////////////////
//	public static void main(String[] args) {
//		final int MAX = 10000;
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		int[] arr = new int[n];
//		int[] stored = new int[n];
//		int[] cntArr = new int[MAX+1];
//	
//		for(int i = 0; i < n; i++) {
//			arr[i] = sc.nextInt();
//			cntArr[arr[i]]++;
//		}
//
//		for(int i = 1; i < MAX+1; i++) 
//			cntArr[i] += cntArr[i-1];
//		
//		for(int i = n-1; 0 <= i; i--) 
//			stored[--cntArr[arr[i]]] = arr[i];
//		
//		for(int i : stored) 
//			System.out.println(i);
//
//	}
}
