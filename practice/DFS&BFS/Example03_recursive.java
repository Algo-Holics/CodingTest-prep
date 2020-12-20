package chapter03_dfsbfs;

public class Example03_recursive {

	public static void main(String[] args) {
		//무한 호출 => Error (recursion error)
		recursiveFunction();
	}
	
	public static void recursiveFunction() {
		System.out.println("재귀 함수를 호출 합니다.");
		recursiveFunction();
	}
}
