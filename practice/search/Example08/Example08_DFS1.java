package chapter03_dfsbfs;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Example08_DFS1 {

	public static void main(String[] args) {
		// java 추가 구현 (예제는 고정된 graph라서, 입력받아 풀 경우 대비하여 구현 해 봄..)
		// 인접리스트 + 재귀
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //정점 수
		int m = sc.nextInt(); //간선 수
		int v = sc.nextInt(); //탐색 시작 정점 번호
		
		boolean visited[] = new boolean [n+1]; //방문 여부 검사
		
		LinkedList <Integer> [] graph = new LinkedList[n+1];
		
		for (int i = 0; i <= n; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		
		// 양방향 그래프
		for(int i = 0 ; i< m; i ++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		
		// 방문 순서 위해 오름차순 정렬
		for(int i = 1; i<= n; i++) {
			Collections.sort(graph[i]);
		}
		
		dfs(graph, v, visited);
	}
	
	public static void dfs(LinkedList<Integer>[] graph, int v ,boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		
		Iterator<Integer> iter = graph[v].listIterator();
		while(iter.hasNext()) {
			int w = iter.next();
			if(!visited[w]) {
				dfs(graph, w, visited);
			}
		}
	}
}


/*
 
 입력
5 5 3
5 4
5 2
1 2
3 4
3 1
 
 출력
 3 1 2 5 4
 
 */
