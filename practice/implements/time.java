package chapter02_implement;

import java.util.Scanner;

public class time {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int cnt = 0;
		
		for(int h = 0; h < n + 1; h++) {
			for (int m = 0; m < 60; m++) {
				for (int s = 0; s < 60; s++) {
					if(h %10 == 3 || m /10 == 3 || m %10 == 3 || s /10 == 3|| s%10 == 3) {
						cnt ++;
					}
				}
			}
		}
		System.out.println(cnt);
//		System.out.println(24 * 60 * 60); //86400번 연산;
	}
}
