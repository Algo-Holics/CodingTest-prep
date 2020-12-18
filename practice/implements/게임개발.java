package chapter02_implement;

import java.util.Scanner;

public class 게임개발 {
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//n, m: 맵의 크기
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//x, y: 현재 위치
		int x = sc.nextInt();
		int y = sc.nextInt();
		//dir = direction, 방향 (0: 북, 1: 동, 2: 남, 3: 서)
		int dir = sc.nextInt();
		
		//바다, 육지를 나타낸 map
		int[][] matrix = new int [n][m];
		//방분 여부 
		int[][] visited = new int [n][m];
		
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		// 위, 오, 아, 왼
//		int[] dx = {-1, 0, 1, 0};
//		int[] dy = {0, -1, 0, 1};
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int cnt = 1;
		int rotate = 0;
		
		// 방문 check
		visited[x][y] = 1;
		
		while(true) {
			// 방향 결정(현재 방향 기준, 왼쪽으로 90도 회전하는 idx 결정)
			dir++;
			if (dir % 4 == 0) {
				dir = 0;
			}
			
			// 다음 좌표 next x, next y
			int nx = x + dx[dir];
			int ny = y + dy[dir];
				
			// 가보지 않았고, 육지일 경우 진행 가능
			if(visited[nx][ny] == 0 && matrix[nx][ny] == 0) {
				x = nx;
				y = ny;
				cnt ++;
				visited[nx][ny] = 1;
				rotate = 0;
				continue;
			}else {
				rotate++;
			}
			
			// 4방향 모두 불가능한 경우
			if(rotate == 4) {
				//back
				nx = x - dx[dir];
				ny = x - dy[dir];
				//육지인 경우 이동
				if (matrix[nx][ny] == 0){
					x = nx;
					y = ny;
				// 바다면 진행 불가능 (종료)
				}else {
					break;
				}
				rotate = 0;
			}
		
		}
		System.out.println(cnt);
	}

}
