package chapter02_implement;

import java.util.Arrays;
import java.util.Scanner;

public class LRUD_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.nextLine(); // 개행문자 enter 받기 위해 한 번 더 추가.
		int x = 1, y = 1;
		
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		char[] dir = {'L','R','U','D'};
		
		String[] instruction = sc.nextLine().split(" ");
		
		for (int i = 0; i < instruction.length; i++) {
			
			int cx = 1, cy = 1;
			
			for(int j = 0 ; j< dir.length; j++) {
				if (dir[j] == instruction[i].charAt(0)) {
					cx = x + dx[j];
					cy = y + dy[j];
				}
			}
			
			if (cx< 1 || cy < 1 || cx>= n || cy >= n) {
				continue;
			}
			
			x = cx;
			y = cy;
		}

		
		System.out.println(x + " " + y);
	}
}

/*
 * 개행문자 해결방법 
 * 1. 위와 같이 개행문자를 한 번 더 입력받는다.
 * 2. nextLine으로 모두 입력받아서 필요한 부분만 parseInt해준다.
 * 3. Scanner 객체를 두개 사용한다.
 * 참조 자료: https://sleepyeyes.tistory.com/22
 * */
