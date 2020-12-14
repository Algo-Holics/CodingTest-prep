package chapter02_implement;

import java.util.Scanner;

public class LRUD_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int cx = 1;
		int cy = 1;
		
		for (int i = 0; i < 6; i++) {
			String dir = sc.next();

			if(dir.equals("R")) {
				cy ++;
				if (cy >= n-1) {
					cy --;
				}
			}else if (dir.equals("L")) {
				cy --;
				if (cy < 0) {
					cy ++;
				}
			}else if (dir.equals("U")) {
				cx --;
				if (cx <0) {
					cx ++;
				}
			}else if (dir.equals("D")) {
				cx ++;
				if (cx >= n-1) {
					cx --;
				}
			}
		}
		
		System.out.println((cx)+" "+ (cy) );
		sc.close();
		
	}
}

/*
 * [방향 벡터로 먼저 접근 못한 이유]
 * 입력 받을 때, nextInt() => nextLine하려고하는데 
 * 개행문자(enter) 입력받아져서 해결방법을 찾기 이전에 
 * 문자열을 next로 일일이 입력받아 구현해봄.
 */
