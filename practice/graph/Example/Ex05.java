package chapter08_graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Ex05 {
	public static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	public static int v, e;
	public static int inDegree[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//v: vertex, e: edge
		v = sc.nextInt();
		e = sc.nextInt();
		//진입차수
		inDegree = new int[v+1];
		
		//각 노드에 연결된 간선 정보 담기위한 연결리스트 초기화
		for(int i = 0; i <= v; i ++) {
			graph.add(new ArrayList<Integer>());
		}
		// 방향 그래프 정보 입력받고, graph에 담아주고(방향 그래프), 진입차수 증가
		for(int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
			inDegree[b]++;
		}
		
		//위상정렬 수행
		topologySort();
		
	}
	private static void topologySort() {
		List <Integer> result = new ArrayList<Integer>();
		Queue <Integer> q = new LinkedList<>();
		
		for(int i = 1 ; i <=v; i++) {
			if (inDegree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			result.add(now);
			
			for(int i : graph.get(now)) {
				inDegree[i] --;
				if(inDegree[i] == 0) {
					q.add(i);
				}
			}
		}
		
		for(int i : result) {
			System.out.print(i + " ");
		}
	}
}


/*
 * 
[TC]
7 8
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4 
 */
