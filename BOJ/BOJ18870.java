package boj;

/**
 * 2021-04-09
 * BOJ 18870 - 좌표 압축
 * Memory: 258,604KB
 * Execution Time: 2320ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Number implements Comparable<Number> {
	int idx;
	int num;

	public Number(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}

	@Override
	public int compareTo(Number o) {
		return this.num - o.num;
	}

}

public class BOJ18870 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());
		Number[] input = new Number[N];
		int[] output = new int[N];

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = new Number(i, Integer.parseInt(st.nextToken()));
		}
		
		// sort
		Arrays.sort(input);
		
		int cnt = 0;					// 중복된 값을 제외한 순서 카운팅 
		int before = input[0].num;		// 이전의 값이랑 같은지 체크하기 위해 만듦
		output[input[0].idx] = cnt;		// 우선 첫 번째 값을 추가!
		for(int i = 1; i < N; i++) {	// for문 돌면서 이전 값과 같으면 순서 증가시키지 않고 그대로(cnt) 저장 
			int n = input[i].num;		//					 다르면 순서 하나 증가시키고 저장 + before값 업데이트
			int idx = input[i].idx;
			
			if(before == n) {
				output[idx] = cnt;
			}else {
				output[idx] = ++cnt;
				before = n;
			}
		}
		
		for(int i = 0; i < N;i++) {
			sb.append(output[i]).append(" ");
		}

		out.write(sb.toString());
		out.close();
		in.close();
	}
}
