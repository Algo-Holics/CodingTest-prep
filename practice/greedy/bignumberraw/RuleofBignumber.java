import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RuleofBignumber{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		Integer[] list = new Integer[n];
		int sum = 0;

		for (int i = 0; i < n; i++) {
			list[i] = sc.nextInt();
		}
		Arrays.sort(list, Comparator.reverseOrder());

		int con = m / k;
		int res = m % k;
		sum += list[0] * k * con;
		sum += res * list[1];
		System.out.println(sum);

	}
}
