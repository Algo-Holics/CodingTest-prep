import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LuckyStraight {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int firsum = 0;
		int secsum = 0;
		int[] ar = new int[input.length()];
		for (int i = 0; i < input.length(); i++) {
			ar[i] = input.charAt(i) - '0';

		}
		for (int i = 0; i < input.length() / 2; i++) {
			firsum += ar[i];
			secsum += ar[ar.length - 1 - i];
		}
		if (firsum == secsum) {
			System.out.println("LUCKY");
		} else {
			System.out.println("READY");
		}

	}

}
