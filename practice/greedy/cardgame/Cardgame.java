package chapter01_greedy;

import java.util.Scanner;

public class 숫자카드게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int ans = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < m; j++) {
				int temp = sc.nextInt();
				if (min > temp) {
					min = temp;
				}
			}
			if (ans < min) {
				ans = min;
			}
		}
		
		System.out.println(ans);
	}
}
