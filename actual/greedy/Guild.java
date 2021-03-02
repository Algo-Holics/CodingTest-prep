package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Guild {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N  = sc.nextInt();
		int[] fear = new int[N];
		for(int i = 0 ; i < N; i++) {
			fear[i] = sc.nextInt();
		}
		
		Arrays.sort(fear);
		
		int cnt = 1, guild = 0;
		for(int X: fear) {
			if(X <= cnt) {
				guild+=1;
				cnt = 1;
			}else {
				cnt++;
			}
		}
		
		System.out.println(guild);
	}

}
