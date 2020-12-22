package chapter03_dfsbfs;

public class Example08_DFS {
	static boolean [] visited = new boolean[9];
	static int graph [][] = {
			{},
			{2, 3, 8},
			{1, 7},
			{1, 4, 5},
			{3, 5},
			{3, 4},
			{7},
			{2, 6, 8},
			{1, 7}
	};
	public static void main(String[] args) {
		// 예제에서는 visited, graph를 매개변수로 담아주었는데,
		// 나는 static 변수로 호출하도록 했다.
		// 인접행렬 + 재귀로 구현하였다.
		dfs(1);
	}	
	
	public static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int i : graph[v]) {
			if (visited[i] == false) {
				dfs(i);
			}
		}
	}
}
