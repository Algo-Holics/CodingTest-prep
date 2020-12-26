package chapter03_dfsbfs;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Example08_DFS2 {

	public static void main(String[] args) {
		// java 추가 구현 
		// 인접 행렬 + (재귀 + 스택)
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //정점 수
		int m = sc.nextInt(); //간선 수
		int v = sc.nextInt(); //탐색 시작 정점 번호
		
		boolean visited[] = new boolean [n+1]; //방문 여부 검사
		
		int[][] graph = new int [n+1][n+1];
		
		
		// 양방향 [가중치는 1로]
		for(int i = 0 ; i< m; i ++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			graph[v1][v2] = 1;
			graph[v2][v1] = 1;
		}
		
		System.out.print("DFS (인접행렬, 재귀): ");
		dfs_array_recursive(v, graph, visited);
		
		// 인접행렬, 스택 구현한거 test하기 위해 초기화함
		Arrays.fill(visited, false);
		
		System.out.print("\n\nDFS(인접행렬, 스택): ");
		dfs_array_stack(v, graph, visited, true);
	}
	
	public static void dfs_array_recursive(int v, int[][] graph, boolean[] visited) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int i = 1; i < graph[v].length ; i++) {
			if(!visited[i] && graph[v][i] == 1) {
				dfs_array_recursive(i, graph, visited);
			}
		}
	}
	
	public static void dfs_array_stack(int v, int[][] graph, boolean[] visited, boolean flag) {
		Stack <Integer> stack = new Stack<Integer>();
		stack.push(v);
		visited[v] = true;
		System.out.print(v + " ");
		
		while(!stack.isEmpty()) {
			v = stack.peek();
			flag = false;
			
			for(int i = 1; i< graph.length; i++) {
				if(!visited[i] && graph[v][i] == 1) {
					stack.push(i);
					System.out.print(i + " ");
					visited[i] = true;
					flag = true;
					
					break;
				}
			}
			
			if(!flag) {
				stack.pop();
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
