import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ¿Õ½Ç³ªÀÌÆ® {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int row = input.charAt(1) - '0';
		int col = input.charAt(0) - 'a' + 1;
		int[] dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
		int currow = 0;
		int curcol = 0;
		int count = 0;
		for (int i = 0; i < 8; i++) {
			currow = row + dx[i];
			curcol = col + dy[i];

			if ((1 <= currow && currow <= 8) && (1 <= curcol && curcol <= 8)) {
				count++;
			}
		}

		System.out.println(count);
	}

}
