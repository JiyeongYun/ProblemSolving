package boj;

/**
 * 2021-03-29
 * BOJ 10814 - 나이순 정렬
 * Memory: 47,328KB
 * Execution Time: 532ms 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ10814 {

	static class Person implements Comparable<Person> {
		int idx;
		int age;
		String name;

		public Person(int idx, int age, String name) {
			super();
			this.idx = idx;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			if (this.age == o.age)
				return this.idx - o.idx;
			return this.age - o.age;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		List<Person> p = new ArrayList<>();
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			p.add(new Person(i, Integer.parseInt(st.nextToken()),st.nextToken()));
		}
		Collections.sort(p);
		for (int i = 0; i < N; i++) {
			sb.append(p.get(i).age).append(" ").append(p.get(i).name).append("\n");
		}
		out.write(sb.toString());
		out.close();
		in.close();
	}
}
