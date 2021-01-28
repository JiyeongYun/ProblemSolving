package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ7568 {
	static class Person{
		int w;	// weight
		int h;	// height
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Person> people = new ArrayList<>();
		int n = sc.nextInt();
		
		// input
		for(int i = 0; i < n; i++) {
			Person p = new Person();
			p.w = sc.nextInt();
			p.h = sc.nextInt();
			people.add(p);
		}
		
		for(int i = 0; i < people.size(); i++) {
			
			int count = 1;
			Person p1 = people.get(i);
			for(int j = 0; j < people.size(); j++) {
				if(i == j) 
					continue;
	
				Person p2 = people.get(j);
				count += ((p1.w < p2.w) ? p1.h < p2.h) ?  1 : 0 : 0; 
				
			}
			
			System.out.print(count + " ");
		}
	}
}


