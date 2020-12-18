import java.util.Scanner;

public class Change {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int first = 500;
		int[] arr = new int[4];
		int[] list = { 500, 100, 50, 10 };
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = N / list[i];
			N = N % list[i];
		}

		for (int count : arr) {
			sum += count;
		}
		System.out.println(sum);

	}
}
