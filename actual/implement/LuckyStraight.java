package implement;

import java.util.Scanner;

public class LuckyStraight {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String N = sc.next();
		
		int left= 0, right=0 ;
		//문자열 절반만큼 돌면서 좌, 우 총합 구하기
		for(int i = 0; i < N.length()/2; i++) {
			left += (N.charAt(i) - '0');
			right += (N.charAt(N.length()-1-i) -'0');
		}
		
		if(left==right) {
			System.out.println("LUCKY");
		}else {
			System.out.println("READY");
		}
		
		sc.close();
	}

}

/* 문제 링크: https://www.acmicpc.net/problem/18406
 */
