package swea;

/**
 * 2021-02-15
 * SWEA 6808 - 규영이와 인영이의 카드게임
 * Memory: 19,920KB
 * Execution Time: 3606ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA6808 {

	static int win, lose, N = 9;
	static int[] arr = new int[19];
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			win = 0;
			lose = 0;
			isSelected = new boolean[19];
			for (int i = 0; i < 9; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				isSelected[arr[i]] = true;
			}
			perm(0, 0, 0);
			sb.append("#").append(t).append(" ").append(win).append(" ").append(lose).append("\n");
		}

		out.write(sb.toString());
		out.close();
		in.close();
	}

	private static void perm(int cnt, int a, int b) {
		if (cnt == N) {
			if (a > b) win++;
			else if (a < b) lose++;
			return;
		}
		for (int i = 1; i <= 18; i++) {
			if (isSelected[i]) continue;

			isSelected[i] = true;
			if (arr[cnt] < i)
				perm(cnt + 1, a, b + arr[cnt] + i);
			else
				perm(cnt + 1, a + arr[cnt] + i, b);
			isSelected[i] = false;
		}
	}
}
