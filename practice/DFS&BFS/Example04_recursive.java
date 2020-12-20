package chapter03_dfsbfs;

public class Example04_recursive {

	public static void main(String[] args) {
		recursive_function(1);
	}
	
	public static void recursive_function(int i) {
		// 100번째 출력시 종료
		if (i == 100) {
			return;
		}
		System.out.println(i + "번쨰 재귀 함수에서" + (i+1) + "번째 재귀 함수를 호출합니다.");
		recursive_function((i+1));
		System.out.println(i + "번째 재귀 함수를 종료 합니다.");
	}
}
