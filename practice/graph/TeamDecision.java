package chapter08_graph;

import java.util.Scanner;

public class TeamDecision {
	public static int[] parent;
	public static int n, m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		initailizeParent();
		
		for(int i = 0; i < m; i++) {
			int opt = sc.nextInt(); 
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(opt == 0) {
				unionParent(a, b);
			}else if(opt == 1) {
				if(findRoot(a)==findRoot(b)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}

	private static void unionParent(int a, int b) {
		a = findRoot(a);
		b = findRoot(b);
		
		if(a>b) {
			parent[a] = b;
		}else {
			parent[b] = a;
		}
	}

	private static int findRoot(int v) {
		if(v != parent[v]) {
			return findRoot(parent[v]);
		}
		return parent[v];
	}

	private static void initailizeParent() {
		parent = new int[n+1];
		for(int i = 0; i <= n ; i++) {
			parent[i] = i;
		}
	}
}

