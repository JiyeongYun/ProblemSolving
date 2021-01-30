package boj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BOJ1427 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder("");
		ArrayList<Integer> arr = new ArrayList<>();
		String n = sc.next();
		
		for(int i = 0; i < n.length(); i++) {
			arr.add(Character.getNumericValue(n.charAt(i)));
		}
		arr.sort(Comparator.reverseOrder());
		for(int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i));
		}
		System.out.println(sb);
		

	}

}
