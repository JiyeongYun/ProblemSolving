package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_SWEA_8458_원점으로집합_윤지영 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(in.readLine());
		for (int t = 1; t <= T; t++) {
			String[] s = in.readLine().split(" ");
			int x1 = Integer.parseInt(s[0]);
			int y1 = Integer.parseInt(s[1]);
			int x2 = Integer.parseInt(s[2]);
			int y2 = Integer.parseInt(s[3]);

			int diffX = Math.abs(x1 - x2);
			int diffY = Math.abs(y1 - y2);
			int diff = Math.max(diffX, diffY) - Math.min(diffX, diffY);

			int result = (Math.min(diffX, diffY) * 2) + diff * 2 - diff % 2;
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}

		out.write(sb.toString());
		out.close();
		in.close();

	}

}