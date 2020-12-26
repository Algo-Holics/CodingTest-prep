package chapter04_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScoreDown {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList <StudentScore> list = new ArrayList<StudentScore>();
		
		for(int i = 0; i < n; i++) {
			String name = sc.next();
			int score = sc.nextInt();
			sc.nextLine();
			
			list.add(new StudentScore(name, score));
		}
		
		Collections.sort(list);
		
		for(int i = 0; i< list.size(); i++) {
			System.out.print(list.get(i).getName() + " ");
		}
	}
}

class StudentScore implements Comparable<StudentScore>{
	private String name;
	private int score;
	
	StudentScore(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return this.name;
	}
	public int getScore() {
		return this.score;
	}

	@Override
	public int compareTo(StudentScore prev) {
		return (this.score > prev.score)? 1 : this.score< prev.score? -1: 0;
	}
}