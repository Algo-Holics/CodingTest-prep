package chapter03_dfsbfs;

public class Example05_factorial {

	public static void main(String[] args) {
		System.out.println("반복: "+factorial_iterative(5));
		System.out.println("재귀: "+factorial_recursive(5));
	}
	
	//iterative factorial
	public static int factorial_iterative(int n) {
		int result = 1;
		while(n > 0) {
			result *= n;
			n --;
		}
		return result;
	}

	// recursive factorial
	public static int factorial_recursive(int n) {
		if(n <= 1) {
			return 1;
		}else {
			return n * factorial_recursive(n-1);
		}
	}
}
