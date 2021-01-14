package chapter06_dp;

import java.util.Scanner;

public class MadeOne {
	public static int dp[]  = new int[30001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		System.out.println(findOne(x));
	}
	private static int findOne(int x) {
		if(x==1) return 0;
		if(dp[x] > 0) return dp[x];
		
		dp[x] = findOne(x-1) + 1;
		
		if(dp[x]%5==0) {
			int temp = findOne(x/5) + 1;
			if(temp < dp[x]) dp[x] = temp;
		}
		if(dp[x]%2==0) {
			int temp = findOne(x/2) + 1;
			if(temp < dp[x]) dp[x] = temp;
		}
		if(dp[x]%3==0) {
			int temp = findOne(x/3) + 1;
			if(temp < dp[x]) dp[x] = temp;
		}
		return dp[x];
	}

}


/*
[문제 풀어낸 순서]
1. x = 1인 경우부터 x = 8 인경우까지 가지치기를 일단 그려봄
2. x = 8 일 때 점화식이 보였음
3. f(x) = (f(x-1)+1, f(x/2) + 1, f(x/3) + 1, f(x/5) + 1) 4개 중 최소값.
  3-1. 단, 2, 3, 5는 나눠 떨어지는 경우만 체크
  3-2. 계산할 때마다, 계속 재귀적으로 하면 stack overflow날 것 같으니 dp에 값을 저장해서 풀기.
 */
