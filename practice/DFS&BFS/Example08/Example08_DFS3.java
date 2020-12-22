package chapter03_dfsbfs;

import java.util.ArrayList;

public class Example08_DFS3 {
	public static boolean[] visited = new boolean[9];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {
		//그래프 초기화
		for(int i = 0; i < 9 ; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		graph.get(1).add(2);
		graph.get(1).add(3);
		graph.get(1).add(8);

		graph.get(2).add(1);
		graph.get(2).add(7);

		graph.get(3).add(1);
		graph.get(3).add(4);
		graph.get(3).add(5);

		graph.get(4).add(3);
		graph.get(4).add(5);

		graph.get(5).add(3);
		graph.get(5).add(4);

		graph.get(6).add(7);

		graph.get(7).add(2);
		graph.get(7).add(6);
		graph.get(7).add(8);

		graph.get(8).add(1);
		graph.get(8).add(7);

		dfs(1);
	}
	
	public static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int i = 0; i < graph.get(v).size(); i++){
			if(!visited[graph.get(v).get(i)]) {
				dfs(graph.get(v).get(i));
			}
		}
	}
}
