package chapter01_greedy;

import java.util.Arrays;
import java.util.Scanner;

public class 큰수의법칙2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		
		int arr [] = new int[n];
		int answer = 0;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int first = arr[arr.length-1];
		int second = arr[arr.length-2];

		int cnt = (m / (k+1)) * k + m % (k+1);
	
		answer += first * cnt;
		answer += second * (m - cnt);
		
		System.out.println(answer);
	}
}
