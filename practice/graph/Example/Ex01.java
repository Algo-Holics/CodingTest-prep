package chapter08_graph;

import java.util.Scanner;

public class Ex01 {
	public static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// v: vertex, e: edge
		int v = sc.nextInt();
		int e = sc.nextInt();
		// parent table
		parent = new int[v + 1];

		// 부모(root) 정보 table 초기화
		initializeParent();

		// 두 node에 대한 root를 찾고, union하기
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			unionParent(a, b);
		}

		// 각 원소가 속한 집합 출력
		printElementSet();
		// 각 원소의 부모 출력
		printParentElement();

	}

	// 두 root중 작은 root로 업데이트
	private static void unionParent(int a, int b) {
		a = findRoot(a);
		b = findRoot(b);
		if (a > b) {
			parent[a] = b;
		} else {
			parent[b] = a;
		}
	}

	// root를 찾아주는 함수
	private static int findRoot(int v) {
		if (parent[v] != v) {
			return findRoot(parent[v]);
		}
		return v;
	}

	// 부모 정보 테이블 초기화
	private static void initializeParent() {
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
	}

	// 부모 테이블 출력
	private static void printParentElement() {
		System.out.print("부모테이블: ");
		for (int i = 1; i < parent.length; i++) {
			System.out.print(parent[i] + " ");
		}
		System.out.println();
	}

	// 속해있는 집합의 root 정보 출력
	private static void printElementSet() {
		System.out.print("각 원소가 속한 집합: ");
		for (int i = 1; i < parent.length; i++) {
			System.out.print(findRoot(i) + " ");
		}
		System.out.println();
	}
}

