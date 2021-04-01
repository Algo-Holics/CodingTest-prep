package implement;

import java.util.*;

public class ChickenDelivery {
	static int[][] board;				//격자판
	static List <Pos> chickenlist;		//치킨집 위치 리스트
	static List <Pos> houselist;		//가정집 위치 리스트
	static int[] chickIdx; 				//조합 결과로 나온 치킨집 index를 담을 배열
	static Pos[] combChick;				//chickIdx로 조합된 결과 위치를 담음.
	static int chickCnt;				//초기에 주어진 치킨집 수
	static int answer;					//출력할 답
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		board = new int[N+1][N+1];
		chickenlist = new ArrayList<>();
		houselist = new ArrayList<>();
		chickCnt = 0;
		
		// 치킨집 위치는 list에 담고, 치킨집이 얼마나 있는지 카운트한다.
		for(int i = 1; i < N+1; i ++) {
			for(int j = 1; j < N+1; j ++) {
				board[i][j] = sc.nextInt();
				if(board[i][j] == 2) {
					chickenlist.add(new Pos(i, j));
					chickCnt++;
				}else if(board[i][j] == 1) {
					houselist.add(new Pos(i, j));
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		chickIdx = new int[M];
		combination(0, M, 0, N);
		System.out.println(answer);
	}


	private static void combination(int location, int M, int idx, int N) {
		//M==0이라는 것은 남겨둘 치킨 조합을 골른 경우.
		if(M==0) {
			//남긴 치킨집들의 위치정보를 combChick에 담아서
			combChick = new Pos[location];
			for(int i = 0; i < location; i++) {
				combChick[i] = chickenlist.get(chickIdx[i]);
			}
			//거리를 확인해주고 기존에 저장해둔 거리보다 작으면 업데이트 해주기.
			checkDist(combChick);
			return;
		}
		//chickCnt는 초기에 가지고 있던 치킨집들 수 이므로 idx가 chickCnt에 도달했으면 더 확인할 필요 없으니 return
		else if(idx == chickCnt) return;
		
		chickIdx[location] = idx;
		combination(location+1, M-1, idx+1, N);
		combination(location, M, idx+1, N);
	}


	private static void checkDist(Pos[] combChick) {
		int ans = 0;
		for(int i = 0; i< houselist.size(); i++) {
			int min = Integer.MAX_VALUE;
			Pos homePos = houselist.get(i);
			for(int j = 0; j < combChick.length; j++) {
				Pos chickPos = combChick[j];
				min = Math.min(min, dist(homePos, chickPos));
			}
			ans+= min;
		}
		
		answer = Math.min(answer, ans);
	}

	private static int dist(Pos house, Pos chick) {
		return Math.abs(house.x - chick.x) + Math.abs(house.y - chick.y);
	}
}

class Pos {
	int x;
	int y;
	
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
}