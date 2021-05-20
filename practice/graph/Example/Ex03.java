package chapter08_graph;

import java.util.Scanner;

public class Ex03 {
	public static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int v = sc.nextInt();
		int e = sc.nextInt();
		parent = new int[v + 1];

		initializeParent();

		boolean cycle = false;		
		
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(findRoot(a) == findRoot(b)) {
				cycle = true;
				break;
			}else {
				unionParent(a, b);
			}
		}

		if(cycle) {
			System.out.println("사이클 있음");
		}else {
			System.out.println("사이클 없음");
		}
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

}
