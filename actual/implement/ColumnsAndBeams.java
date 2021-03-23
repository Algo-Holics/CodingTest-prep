package implement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ColumnsAndBeams2 {

	public static void main(String[] args) {
		int[][] temp1 = new Sol6().solution(5, new int[][] { { 1, 0, 0, 1 }, { 1, 1, 1, 1 }, { 2, 1, 0, 1 }, { 2, 2, 1, 1 },
				{ 5, 0, 0, 1 }, { 5, 1, 0, 1 }, { 4, 2, 1, 1 }, { 3, 2, 1, 1 } });
		int[][] temp2 = new Sol6().solution(5, new int[][] { { 0, 0, 0, 1 }, { 2, 0, 0, 1 }, { 4, 0, 0, 1 }, { 0, 1, 1, 1 },
				{ 1, 1, 1, 1 }, { 2, 1, 1, 1 }, { 3, 1, 1, 1 }, { 2, 0, 0, 0 }, { 1, 1, 1, 0 }, { 2, 2, 0, 1 } });
		
		
		print(temp1);
		print(temp2);
	}
	
	public static void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}


class Sol6{
	static boolean[][] cols, rows;
	int n;
	
	public int[][] solution(int n, int[][] build_frame) {
		//n field 영역에 할당해두기
		this.n = n;

		//가능한 기둥(cols) 보(rows) 담기
		cols = new boolean[n + 3][n + 3];
		rows = new boolean[n + 3][n + 3];

		List <Dir> tempAns = new ArrayList<>();
		int answer [][];
		
		for (int[] build : build_frame) {
			int x = build[0] + 1;
			int y = build[1] + 1;
			int a = build[2]; // 기둥 (0) , 보(1)
			int b = build[3]; // 삭제 (0) , 설치(1)

			// 설치
			if (b == 1) {
				if (a == 0 && isColAvailable(x, y)) {
					cols[x][y] = true;
				} else if (a == 1 && isRowAvailable(x, y)) {
					rows[x][y] = true;
				}
			// 삭제
			} else if (b == 0) {
				if (a == 0 && canRemove(x, y, 0)) {
					cols[x][y] = false;
				// 보
				} else if (a == 1 && canRemove(x, y, 1)) {
					rows[x][y] = false;
				}
			}
		}

		for(int i = 1; i <= n+1; i++) {
			for(int j = 1; j <= n+1; j++) {
				if(cols[i][j]) tempAns.add(new Dir(i-1, j-1, 0));
				if(rows[i][j]) tempAns.add(new Dir(i-1, j-1, 1));
			}
		}
		
		Collections.sort(tempAns);

		answer = new int[tempAns.size()][3];
		for(int i = 0; i < tempAns.size(); i++) {
			answer[i][0] = tempAns.get(i).x;
			answer[i][1] = tempAns.get(i).y;
			answer[i][2] = tempAns.get(i).cb;
		}
		
		
		return  answer;
	}

	private boolean canRemove(int x, int y, int type) {
		boolean ret = true;
		//임시삭제
		if(type == 0) {
			cols[x][y] = false;
		}else {
			rows[x][y] = false;
		}
		
		//삭제해도 괜찮은지 check
		outer: for (int i = 1; i <= n+1; i++) {
			for (int j = 1; j <= n+1; j++) {
				if (cols[i][j] && !isColAvailable(i, j)) {
					ret = false;
					break outer;
				} else if (rows[i][j] && !isRowAvailable(i, j)) {
					ret = false;
					break outer;
				}
			}
		} 
		
		//check 완료했으니 원상복구
		if(type == 0) {
			cols[x][y] = true;
		}else {
			rows[x][y] = true;
		}
		
		// 결과 반환
		return ret;
	}

	// 기둥 설치 조건: 1. 왼쪽 바닥 2. 왼쪽 기둥 3. 현재 위치에 보가 있거나 4. 
	public boolean isColAvailable(int x, int y) {
		return y == 1 || cols[x][y - 1] || rows[x][y] || rows[x-1][y];
	}

	// 보 설치 조건: 1. 아래에 기둥이 있거나 2. 위아래에 보가 있거나 3. 오른쪽 아래가 기둥이면 가능
	public boolean isRowAvailable(int x, int y) {
		return cols[x][y-1] || rows[x - 1][y] && rows[x + 1][y] || cols[x + 1][y - 1];
	}

}
class Dir implements Comparable<Dir> {
	int x;
	int y;
	int cb;

	Dir(int x, int y, int cb) {
		this.x = x;
		this.y = y;
		this.cb = cb;
	}

	@Override
	public int compareTo(Dir o) {
		if (this.x == o.x && this.y == o.y) {
			return Integer.compare(this.cb, o.cb);
		} else if (this.x == o.x) {
			return Integer.compare(this.y, o.y);
		} else {
			return Integer.compare(this.x, o.x);
		}
	}
}