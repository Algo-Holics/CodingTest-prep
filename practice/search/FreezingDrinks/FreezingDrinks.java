package chapter03_dfsbfs;

import java.util.Scanner;

public class FreezingDrinks {
	public static int n , m;
	public static char[][] matrix;
	public static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		sc.nextLine();
		
		matrix = new char[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i< n; i++) {
			matrix[i] = sc.nextLine().toCharArray();
		}
		int cnt = 0;
		
		for(int i = 0; i< n; i ++) {
			for(int j = 0; j< m; j ++) {
				if (dfs(i, j)) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	
	//dfs로 하고싶은거: 얼음 가능 여부 체크
	public static boolean dfs(int r, int c) {

		//matrix크기를 벗어났거나, 현재 위치가 얼음 칸막이면 바로 종료
		if(r<0 || c<0 || r>= n|| c>= m || matrix[r][c] == '1') {
			return false;
		}
		if(!visited[r][c]) {
			visited[r][c] = true;
			//상하좌우 방문하기
			dfs(r-1, c);
			dfs(r, c-1);
			dfs(r+1, c);
			dfs(r, c+1);
			
			return true;
		}
		return false;
	}
}


/*
[입력 조건1]
4 5
00110
00011
11111
00000

[입력 조건2]
15 14
00000111100000
11111101111110
11011101101110
11011101100000
11011111111111
11011111111100
11000000011111
01111111111111
00000000011111
01111111111000
00011111111000
00000001111000
11111111110011
11100011111111
11100011111111


*/