package chapter02_implement;

import java.util.Scanner;

public class 왕실의나이트 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] input = sc.nextLine().split("");
		
		// 입력받은 현재 위치
		int r = Integer.parseInt(input[1]);
		int c = input[0].charAt(0) -'a' + 1;
		
		// rDir: row Direction, cDir: column Direction (방향 벡터)
		int[] rDir = {-1,1, -1, 1, 2, 2, -2, -2};
		int[] cDir = {2, 2, -2, -2, -1, 1, -1, 1};
		
		// cnt: 가능한 경우의 수 count
		int cnt = 0;
		
		for (int i = 0; i < cDir.length; i++) {
			//임시 좌표 (temp row, temp column)
			int tr = r + rDir[i];
			int tc = c + cDir[i];
			
			if (tr < 1 || tc < 1 || tr> 8 || tc > 8) {
				continue;
			}
			cnt++;
		}

		System.out.println(cnt);
	}
}

/* [사고 흐름]
 * 1. input에 입력을 받아 행, 열을 쪼개 배열로 담기
 * 2. 열을 숫자로 표현하여 변경하기
 * 3. 경우의 수 찾기  
 */