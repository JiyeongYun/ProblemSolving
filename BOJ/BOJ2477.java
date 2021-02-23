package boj;

/**
 * 2021-02-24
 * BOJ 2477 - 참외밭
 * Memory: 11648KB
 * Execution Time: 84ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2477 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int K = Integer.parseInt(in.readLine());
		Queue<Integer> arr = new LinkedList<>();

		// ew: 가로 최대길이 저장 (가로 방향을 가리키는 East, West의 앞글자를 따옴)
		// ns: 세로 최대길이 저장 (세로 방향을 가리키는 North, South의 앞글자를 따옴)
		int ew = 0, ns = 0;
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int dir = Integer.parseInt(st.nextToken()); // 방향
			int len = Integer.parseInt(st.nextToken()); // 길이
			arr.add(len);

			if (dir == 1 || dir == 2) { // 가로 방향 중에서
				ew = ew < len ? len : ew;
			} else {
				ns = ns < len ? len : ns;
			}
		}

		// 큰 네모(직사각형 넓이)에서 작은 네모(빈 공간)를 빼는 로직
		// [작은 네모 구하는 방법]
		// 1. 가장 긴 가로, 세로 길이를 제외한 나머지 길이들을 입력받은 순서대로 나열한다.
		// 2. a,b,c,d 순으로 나열이 되었다면 중간값인 b,c의 값이 작은 네모의 가로, 세로 길이가 된다.
		// ex) 	입력받은 길이가 50, 160, 30, 60, 20, 100인 경우 
		// 		1. 가장 긴 가로, 세로 길이인 160,50을 제외한 나머지 길이를 입력받은 순서대로 나열하면 30,60,20,100 
		//			- 가장 긴 가로, 세로 변은 붙어 있다. 
		//			- 이 점을 이용하여 Queue를 사용해 가장 긴 가로, 세로 변이 붙어있는 경우를 찾고 그 경우일 때 아래 2번을 실행한다. 
		//		2. 여기서 중간 값인 60,20이 작은 네모의 넓이를 구할 수 있는 가로,세로 길이가 된다. 
		//		3. 따라서, 최종적인 계산은 {큰 네모 넓이(160*50) - 작은 네모 넓이(60*20)} * K 
		int bigArea = ew * ns;
		int smallArea;
		while (true) {
			int n1 = arr.remove();
			int n2 = arr.peek();

			if ((n1 == ew && n2 == ns) || (n1 == ns && n2 == ew)) {
				arr.remove();
				arr.remove();
				smallArea = arr.remove() * arr.remove();
				break;
			}

			arr.add(n1);
		}
		out.write(sb.append((bigArea - smallArea) * K).toString());
		out.close();
		in.close();
	}
}
