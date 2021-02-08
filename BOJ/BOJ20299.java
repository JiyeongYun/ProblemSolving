package boj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ20299 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringBuilder startSb = new StringBuilder();
		StringTokenizer st;
		
		// StringTokenizer를 이용하여 N, S, M의 값 입력받아 저장하기
		st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 스마트클럽 가입 가능한 동아리 수 
		int possibleCnt = 0;
		
		
		while(0 < N--) {
			// 학생들의 능력치를 저장하는 배열
			int[] grades = new int[3];
			
			// 제일 1번째 학생의 데이터를 먼저 입력받아 sum, min, grades[0] 값에 저장
			st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int sum = n;
			int min = n;
			grades[0] = n;
			
			// 2, 3번째 학생의 데이터를 입력받기 
			for(int i = 1; i <= 2; i++) {
				n = Integer.parseInt(st.nextToken());
				grades[i] = n;
				sum += n;
				
				// 입력받은 학생의 능력치가 최소값보다 작으면 change
				min = n < min ? n : min;
			}
			
			// 스마트 클럽을 가입하기 위한 조건에 만족하면,
			if(S <= sum && M <= min) {
				
				// 스마트클럽 가입 가능한 동아리 수 하나 증가시키기
				possibleCnt ++;
				
				// 해당 동아리 학생들의 능력치를 추가하기 
				for(int i : grades) {
					sb.append(i).append(" ");
				}
				
			}
			
		}
		
		// 스마트클럽 가입 가능한 동아리 수는 제일 앞에 출력해야 하므로, 새로운 StringBuilder에 추가 후 출력
		startSb.append(possibleCnt).append("\n");
		out.write(startSb.toString());
		
		// 제일 마지막에 포함되는 학생의 능력치 뒤에 포함되는 " " 공백 하나를 제거
		// 데이터가 없으면 에러가 나기 때문에 StringBuilder의 길이를 확인 후 제거하기 
		if(sb.length() > 0) 
			sb.setLength(sb.length()-1);
		
		out.write(sb.toString());
		out.close(); in.close();

	}

}
