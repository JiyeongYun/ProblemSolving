package boj;

/**
 * 2021-06-04
 * BOJ 1931 - 회의실 배정 
 * Memory: 
 * Execution Time: 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Meeting implements Comparable<Meeting> {
	int start;
	int end;

	public Meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Meeting o) {
		if(this.end == o.end) return this.start - o.start;
		return this.end - o.end;
	}
}

public class BOJ1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		// input
		int N = Integer.parseInt(in.readLine());
		Meeting[] meetings = new Meeting[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(meetings);

		for (int i = 1; i < N; i++) {

			System.out.println("Start: " + meetings[i].start + ", End: " + meetings[i].end);
		
		
	}
		System.out.println("======================");

		// calculate
		int num = 1;
		int e = meetings[0].end;
		System.out.println("Start: " + meetings[0].start + ", End: " + meetings[0].end);
		for (int i = 1; i < N; i++) {
			if (e <= meetings[i].start) {
				System.out.println("Start: " + meetings[i].start + ", End: " + meetings[i].end);
				;
				e = meetings[i].end;
				num++;
			}
		}
		System.out.println(num);
		in.close();
	}
}
