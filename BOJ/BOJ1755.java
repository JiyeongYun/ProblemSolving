package boj;

/**
 * 2021-03-12
 * BOJ 1755 - 숫자놀이
 * Memory: 11,620KB
 * Execution Time: 76ms 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1755 {

	static class Number implements Comparable<Number> {
		int n;
		String str;

		public Number(int n, String str) {
			super();
			this.n = n;
			this.str = str;
		}

		@Override
		public int compareTo(Number o) {		
		//  문자열 기준으로 정렬 (동일한 문자열은 존재하지 않기 때문에 숫자 기준으로 정렬은 하지 않음)
			return this.str.compareTo(o.str);
		}

	}

	// numToEng: 0~9까지의 영어 단어를 저장한 배열 (index로 수월하게 접근 가능)
	// list: M 이상 N 이하의 숫자를 문자열로 변환한 값을 저장할 리스트 
	static String[] numToEng = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	static ArrayList<Number> list;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");	// StringTokenizer로 input 값 받기
		int M = Integer.parseInt(st.nextToken()); 	// StringTokenizer의 첫 번째 값: M
		int N = Integer.parseInt(st.nextToken()); 	// StringTokenizer의 두 번째 값: N
		list = new ArrayList<>();

		for (int num = M; num <= N; num++) { 		// M이상 N이하의 숫자를 하나씩 search
			int n = num;							// for문에 영향이 가지 않도록 새로운 변수에 num값을 저장 
			String str = "";						// str: 숫자를 영어 문자열로 바꾸는 값을 저장할 변수 
			while (n > 9) {							// 숫자가 두자리 이상인 경우 while문 계속 반복
				int rem = n % 10;					// 1의 자리를 구해서 
				str = (" " + numToEng[rem]) + str;	// string '앞'에 추가하기
				n = n / 10;						
			}

			str = (" " + numToEng[n]) + str;		// while문을 탈출한 경우: 1의 자리 숫자이기 때문에 남은 값 마저 처리해주기
			list.add(new Number(num, str.trim()));	// 숫자와 문자열을 저장(띄어쓰기는 trim()을 사용하여 제거하고 저장)

		}

		Collections.sort(list);						// 문자열 기준으로 정렬

		int cnt = 0;								// 10개씩 출력하기 위한 count 변수 
		for (int i = 0; i < list.size(); i++) {		// 정렬된 값을 하나씩 출력 
			sb.append(list.get(i).n).append(" ");
			if (cnt++ == 9) {						// 10개씩 출력하기 위해 cnt 변수 값이 9가 되면 0으로 초기화 및 엔터 추가
				cnt = 0;
				sb.append("\n");
			}
		}

		out.write(sb.toString());
		out.close(); in.close();
	}

}