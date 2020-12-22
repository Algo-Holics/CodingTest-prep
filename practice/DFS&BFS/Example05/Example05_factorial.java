package chapter03_dfsbfs;

public class Example05_factorial {

	public static void main(String[] args) {
		System.out.println("반복: "+factorialIterative(5));
		System.out.println("재귀: "+factorialRecursive(5));
	}
	
	//iterative factorial
	public static int factorialIterative(int n) {
		int result = 1;
		while(n > 0) {
			result *= n;
			n --;
		}
		return result;
	}

	// recursive factorial
	public static int factorialRecursive(int n) {
		if(n <= 1) {
			return 1;
		}else {
			return n * factorialRecursive(n-1);
		}
	}
}
