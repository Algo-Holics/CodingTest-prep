import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LRUD {
	public static void main(String[] args) throws IOException {
		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { -1, 1, 0, 0 };
		int x = 1;
		int y = 1;
		int curx = 0;
		int cury = 0;
		String[] pos = { "L", "R", "U", "D" };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		String[] ar = new String[st.countTokens()];
		for (int i = 0; i < ar.length; i++) {
			ar[i] = st.nextToken();
		}
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < pos.length; j++) {
				if (ar[i].equals(pos[j])) {
					curx = x + dx[j];
					cury = y + dy[j];

				}
			}
			if (curx < 1 || curx > n || cury < 1 || cury > n) {
				continue;
			}
			x = curx;
			y = cury;

		}
		System.out.println(x + " " + y);
	}

}
