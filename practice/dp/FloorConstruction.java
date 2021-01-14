package chapter06_dp;

import java.util.Scanner;

public class FloorConstruction {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[n+1];
		
		dp[1] = 1;
		dp[2] = 3;
		
		for(int i = 3; i <= n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]+dp[i-2]) % 796796;
		}
		
		System.out.println(dp[n]);
	}
}

/*
 * 문제 해설이 이해가 안갔었는데, (왜 i-2까지 덮개가 채워져있을때, 경우의수가 2인가 했음. 3이라고 생각함..)
 * 다시 생각해보니까, 맨끝애 2X1 직사각형을 2개 배치하는거는 i-1까지 덮개 채우고, 
 * 2X1짜리 직사각형 하나 채우는거랑 같으니까 제외해서 2가지였다니...ㅎ....눈물...ㅠㅠ
 */