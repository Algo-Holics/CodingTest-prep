package chapter07_ShortestPath;

import java.util.Scanner;

public class Ex03 {
	public static int INF = (int) (1e9);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int graph[][] = new int[n + 1][n + 1];
		// graph INF로 초기화 + 대각선 왼쪽위부터 오른쪽아래로 가는 방향은 모두 0으로.
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				graph[i][j] = INF;
				if (i == j) {
					graph[i][j] = 0;
				}
			}
		}

		// 입력받은 노드 출발 => 도착으로 가는 간선 업데이트
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();

			graph[x][y] = w;
		}

		// 점화식 따라서 플로이드 워셜 알고리즘 수행
		for (int i = 1; i < n + 1; i++) {
			for (int a = 1; a < n + 1; a++) {
				for (int b = 1; b < n + 1; b++) {
					graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
				}
			}
		}

		// 출력
		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				if (graph[a][b] == INF) {
					System.out.print("INFINITY ");
				} else {
					System.out.print(graph[a][b] + " ");
				}
			}
			System.out.println();
		}
	}

}


/*
[TC]
4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2

*/
