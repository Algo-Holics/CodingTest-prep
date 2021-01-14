package chapter06_dp;

import java.util.Scanner;

public class AntWarrior {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];
		
		for (int i = 0 ; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		dp[0] = arr[0];
		dp[1] = Math.max(arr[0], arr[1]);
		
		for(int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2] + arr[i]);
		}
	}
}
