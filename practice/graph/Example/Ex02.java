package chapter08_graph;

import java.util.Scanner;

public class Ex02 {
	public static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int v = sc.nextInt();
		int e = sc.nextInt();
		parent = new int[v + 1];

		initializeParent();

		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			unionParent(a, b);
		}

		printElementSet();
		printParentElement();

	}

	private static void unionParent(int a, int b) {
		a = findRoot(a);
		b = findRoot(b);
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}
	
	//경로 압축 (Ex01에서 효율을 위해서 재귀적으로 바로 parent table을 업데이트 한다.)
	private static int findRoot(int v) {
		if (parent[v] != v) {
			parent[v] = findRoot(parent[v]);
		}
		return parent[v];
	}

	private static void initializeParent() {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	private static void printParentElement() {
		System.out.print("부모테이블: ");
		for (int i = 1; i < parent.length; i++) {
			System.out.print(parent[i] + " ");
		}
		System.out.println();
	}

	private static void printElementSet() {
		System.out.print("각 원소가 속한 집합: ");
		for (int i = 1; i < parent.length; i++) {
			System.out.print(findRoot(i) + " ");
		}
		System.out.println();
	}
}

