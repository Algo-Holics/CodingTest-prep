package greedy;

import java.util.Scanner;

public class FlipString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		
		int zero = 0, one = 0;
		
		if(S.charAt(0)-'0' == 0) {
			one+=1;
		}else {
			zero+=1;
		}
		
		for(int i = 1; i < S.length(); i++) {
			int prev = S.charAt(i-1) - '0';
			int now = S.charAt(i) - '0';
			if(prev!= now) {
				if(now == 1) {
					one++;
				}else if(now == 0) {
					zero++;
				}
			}
		}
//		System.out.println(zero +" " +one);
		System.out.println(Math.min(zero, one));
	}

}
