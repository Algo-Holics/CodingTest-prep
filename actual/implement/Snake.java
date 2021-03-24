package implement;

import java.util.*;

public class Snake {
	// 오, 아, 왼, 위 (0,1,2,3)
	static final int[] dx = { 0, 1, 0, -1 };
	static final int[] dy = { 1, 0, -1, 0 };
	// dir: 현위치, N: board크기, K:사과 갯수
	static int dir, N, K;
	static int board[][];
	// 시간별 회전 방향 담는 배열
	static int Turn[][];
	// 뱀 몸통 담는 배열
	static List<Body> snake;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		board = new int[N + 1][N + 1];

		// dir(맨처음 오른쪽(0)방향으로 시작), 뱀 몸통 시작위치 (1,1)
		dir = 0; 
		snake = new ArrayList<>();
		snake.add(new Body(1, 1));

		// 사과 위치 입력 (사과 1로 표시)
		for (int i = 0; i < K; i++) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			board[row][col] = 1;
		}

		// Turn 정보 입력 (D: 오른쪽 1, L: 왼쪽 -1)
		int L = sc.nextInt();
		Turn = new int[L][2];
		for (int i = 0; i < L; i++) {
			Turn[i][0] = sc.nextInt();
			Turn[i][1] = sc.next().charAt(0) == 'D' ? 1 : -1;
		}
		;

		// 현위치 머리 기준 (1,1)
		int cx = 1, cy = 1;
		int time = 0, turnIdx = 0;

		// 게임 시작
		outer: while (true) {
			time++;

			// 다음 머리 위치
			int nx = cx + dx[dir];
			int ny = cy + dy[dir];
			
			// board 넘어선 경우 게임 종료
			if (nx <= 0 || nx > N || ny <= 0 || ny > N)
				break;

			// 자기 몸통에 걸린 경우 게임 종료(while문 종료)
			for (int i = 0; i < snake.size(); i++) {
				if (nx == snake.get(i).r && ny == snake.get(i).c) {
					break outer;
				}
			}

			// 사과 먹은 경우 몸통 추가하고, 사과 자리 초기화 
			if (board[nx][ny] == 1) {
				snake.add(new Body(nx, ny));
				board[nx][ny] = 0;  //사과 먹었으면 지워야지..(휴...이거로 시간 애먹음)
			} else {
			// 사과 안 먹은 경우 몸통추가 & 꼬리 제거
				snake.add(new Body(nx, ny));
				snake.remove(0);
			}

			// 현재 머리 위치 이동
			cx = nx;
			cy = ny;

			
			// turnIdx가 전체 Turn횟수보다는 작을때까지만.
			if (turnIdx < L) {
				// Turn에 저장해둔 시간과 현재 시간이 일치하면 회전
				if (time == Turn[turnIdx][0]) {
					//회전해서 이동할 다음 방향 결정
					int nxtDir = (dir + Turn[turnIdx][1]) % 4;
					if (nxtDir == -1) {
						nxtDir = 3;
					}
					dir = nxtDir;
					turnIdx++;
				}
			}

		}
		System.out.println(time);
	}

}

class Body {
	int r;
	int c;

	Body(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
