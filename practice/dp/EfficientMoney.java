package chapter06_dp;

import java.util.Scanner;

public class EfficientMoney {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int dp[] = new int[10001];
		
		for(int i = 1; i <= m; i++) {
			dp[i] = 100001;
		}
		
		for(int i = 1; i <= n; i++) {
			int coin = sc.nextInt();
			for(int j = coin; j <= m; j++) {
				dp[j] = Math.min(dp[j-coin] + 1, dp[j]);
			}
		}
		
		System.out.println((dp[m] == 100001) ? -1 : dp[m]); 
	}
}
