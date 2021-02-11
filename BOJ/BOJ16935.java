package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ16935 {

	static int n, m, r;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] arr;
	static List<Integer> opList;
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		arr = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		opList = new ArrayList<>();
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < r; i++) opList.add(Integer.parseInt(st.nextToken()));

		
		for (int i : opList) {
			switch (i) {
			case 1:
				one();
				break;
			case 2:
				two();
				break;
			case 3:
				three();
				break;
			case 4:
				four();
				break;
			case 5:
				five();
				break;
			case 6:
				six();
				break;
			default:
				break;
			}
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				out.append(arr[i][j] + " ");
			}
			out.append("\n");
		}
		
		out.flush();
		out.close();
	}

	static void one() {
		for (int i = 1; i <= arr.length / 2; i++) {
			int[] temp = arr[i];
			arr[i] = arr[arr.length - i];
			arr[arr.length - i] = temp;
		}

	}

	static void two() {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= arr[i].length / 2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][arr[i].length - j];
				arr[i][arr[i].length - j] = temp;
			}
		}
	}

	static void three() {
		int[][] temp = copy(arr);
		n = temp.length - 1;
		m = temp[0].length - 1;
		arr = new int[m + 1][n + 1];
		for (int i = 1, j = n; j >= 1; j--, i++) {
			for (int k = 1; k <= m; k++) {
				arr[k][j] = temp[i][k];
			}
		}
	}

	static void four() {
		int[][] temp = copy(arr);
		n = temp.length - 1;
		m = temp[0].length - 1;
		arr = new int[m + 1][n + 1];
		for (int i = 1, j = 1; j <= n; j++, i++) {
			for (int k = 1; k <= m; k++) {
				arr[k][j] = temp[i][m - k + 1];
			}
		}
	}

	static void five() {
		int[][] temp = copy(arr);
		n = temp.length - 1;
		m = temp[0].length - 1;
		for (int j = 1; j <= n / 2; j++) {
			for (int i = 1; i <= m / 2; i++) {
				arr[j][m / 2 + i] = temp[j][i];
			}
		}
		for (int j = n / 2 + 1; j <= n; j++) {
			for (int i = m / 2 + 1; i <= m; i++) {
				arr[j][i - m / 2] = temp[j][i];
			}
		}
		for (int j = 1; j <= n / 2; j++) {
			for (int i = m / 2 + 1; i <= m; i++) {
				arr[j + n / 2][i] = temp[j][i];
			}
		}
		for (int j = n / 2 + 1; j <= n; j++) {
			for (int i = 1; i <= m / 2; i++) {
				arr[j - n / 2][i] = temp[j][i];
			}
		}
	}

	static void six() {
		int[][] temp = copy(arr);
		n = temp.length - 1;
		m = temp[0].length - 1;

		for (int j = 1; j <= n / 2; j++) {
			for (int i = 1; i <= m / 2; i++) {
				arr[j + n / 2][i] = temp[j][i];
			}
		}
		for (int j = n / 2; j <= n; j++) {
			for (int i = 1; i <= m / 2; i++) {
				arr[j][m / 2 + i] = temp[j][i];
			}
		}
		for (int j = n / 2 + 1; j <= n; j++) {
			for (int i = m / 2 + 1; i <= m; i++) {
				arr[j - n / 2][i] = temp[j][i];
			}
		}
		for (int j = 1; j <= n / 2; j++) {
			for (int i = m / 2 + 1; i <= m; i++) {
				arr[j][i - m / 2] = temp[j][i];
			}
		}
	}

	static int[][] copy(int[][] arr) {
		int[][] temp = new int[arr.length][arr[0].length];
		for (int i = 1; i <= arr.length - 1; i++) {
			for (int j = 1; j <= arr[0].length - 1; j++) {
				temp[i][j] = arr[i][j];
			}
		}
		return temp;
	}

}
