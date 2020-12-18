import java.util.Arrays;
import java.util.Scanner;

public class Cardgame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int max = 0;
		int[][] ar = new int[n][m];
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				ar[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			Arrays.sort(ar[i]);
		}
		max = ar[0][0];
		for (int i = 0; i < ar.length; i++) {
			if (max < ar[i][0]) {
				max = ar[i][0];
			}
		}
		System.out.println(max);
	}

}
