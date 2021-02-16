package jungol;

/**
 * 2021-02-16
 * JUNGOL 1828 - 냉장고
 * Memory: 13,060KB
 * Execution Time: 187ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JUNGOL1828 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
			int abs = o1[0] - o2[0];
			return abs == 0 ? o1[1] - o2[1] : abs;
		});

		int T = Integer.parseInt(in.readLine());
		while (0 < T--) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			pq.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		// First Range
		int cnt = 1;
		int[] range = pq.remove();
		int p = range[0];
		int q = range[1];

		while (!pq.isEmpty()) {
			range = pq.remove();
			int np = range[0];
			int nq = range[1];

			if (q < np) {
				p = np;
				q = nq;
				cnt++;
			} else if (p < np && np < q) {
				p = np;
				q = nq < q ? nq : q;
			}
		}

		out.write(sb.append(cnt).toString());
		out.close();
		in.close();
	}
}
